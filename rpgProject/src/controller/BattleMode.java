package controller;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

import javax.management.monitor.Monitor;

import models.Player;
import models.Unit;
import models.monster;

public class BattleMode {
	Scanner scan = new Scanner(System.in);
	Unit party[] = new Unit[4];
	private Guild guild = Guild.guild;
	public static BattleMode bt = new BattleMode();
	private Random ran = new Random();

	public BattleMode() {// ���⼭ ��� ����Ʈ �Ⱥҷ���//���⼭ ��ŸƮ
		int cnt = 0;
		for (int i = 0; i < guild.guildList.size(); i++) {
			if (guild.guildList.get(i).isParty()) {
				party[cnt] = guild.guildList.get(i);
				cnt++;
			}

		}
	}

	public void battle() {
		System.out.println("�ڡڡڡڡڡڡ��������ۡڡڡڡڡڡڡ�");
		monster mob = new monster();
		spawn(mob.getName(), mob.getHp(), mob.getAtk());
		while (true) {
			turn(mob);
			if (mob.getHp() > 0) {
				mobstat(mob);
				mobatk(mob);
			} else {
				clear(mob);
				break;
			}
		}

	}

	public void clear(monster mob) {
		System.out.println();
		System.out.println("=====[" + mob.getName() + "]�� óġ�߽��ϴ�======");
		for (int i = 0; i < party.length; i++) {
			int exp = party[i].getExp();
			int expPlus = mob.getAtk();
			party[i].setExp(exp + expPlus);
			System.out.println("----" + party[i].getName() + expPlus + "EXP ȹ��!---------");
		}
		int money = ran.nextInt(900) + 100;
		Player.money += money;
		System.out.println("=====��� " + money + "ȹ��!=======");
		System.out.println();
		level();

		for (int i = 0; i < party.length; i++) {
			if (!party[i].isLife()) {
				Player.inven.recoveryItem(i);
				guild.guildList.remove(i);
				for (int j = 0; j < guild.guildList.size(); j++) {// ������ ���� ��Ƽ �ѱ��
					if (guild.guildList.get(j).isParty() == false) {
						guild.guildList.get(j).setParty(true);
						break;
					}
				}
			}
		}

	}

	public void level() {
		for (int i = 0; i < party.length; i++) {
			if (party[i].getExp() >= (party[i].getLevel() * 10)) {
				party[i].setExp(party[i].getExp() - (party[i].getLevel() * 10));
				party[i].setLevel(party[i].getLevel() + 1);
				party[i].setMaxHp(party[i].getMaxHp() + (party[i].getMaxHp() / 5));
				System.out.println(party[i].getName() + "��(��) ������ �ö���!");
			}

		}

	}

	public void mobatk(monster mob) {
		System.out.println("=====[" + mob.getName() + "]�� ����!======");
		int num = ran.nextInt(4);
		int hp = party[num].getHp() - mob.getAtk();
		party[num].setHp(hp);
		System.out.println("[" + party[num].getName() + "��(��) " + mob.getAtk() + "�� ���ظ� �Ծ����ϴ�.]");
		healthCheck(num);
	}

	public void healthCheck(int i) {
		if (party[i].getHp() <= 0) {
			System.out.println(party[i].getName() + "�� ����߽��ϴ�.");
			party[i].setLife(false);
		}
	}

	public void mobstat(monster mob) {
		System.out.println();
		System.out.println("=======[" + mob.getName() + " �� ����ü��]=======");
		System.out.println("------[ü   ��:" + mob.getHp() + "]-------");
		System.out.println("============================");
		System.out.println();
	}

	public void spawn(String name, int hp, int atk) {
		System.out.println("=======[" + name + " ����]=======");
		System.out.println("------[ü   ��:" + hp + "]-------");
		System.out.println("------[���ݷ�:" + atk + " ]-------");
	}

	public void atk(int i, monster mob) {
		System.out.println("=====[" + party[i].getName() + "]�� ����!======");
		int hp = mob.getHp();
		hp -= party[i].getAtt();
		mob.setHp(hp);
		System.out.println("====" + party[i].getAtt() + "�� ������ �� �������ϴ�=====");
	}

	public void heal(int i, monster mob) {
		int hp = party[i].getHp();
		int heal = party[i].getMaxHp() / 4;
		if ((hp + heal) > party[i].getMaxHp()) {
			party[i].setHp(party[i].getMaxHp());
		} else {
			party[i].setHp(hp + heal);
		}
		System.out.println("===" + party[i].getName() + "��(��) ü���� ȸ���߽��ϴ�.");
	}

	public void turn(monster mob) {
		int select[] = new int[4];
		for (int i = 0; i < party.length; i++) {
			System.out.println("=======[" + party[i].getName() + "]========");
			System.out.println("ü   ��:" + party[i].getHp());
			System.out.println("���ݷ�:" + party[i].getAtt());
			System.out.println("[1.����] [2.��]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				select[i] = 1;
			} else if (sel == 2) {
				select[i] = 2;
			}
		}
		for (int i = 0; i < select.length; i++) {
			if (select[i] == 1) {
				atk(i, mob);
			} else if (select[i] == 2) {
				heal(i, mob);
			}
		}

	}

}
