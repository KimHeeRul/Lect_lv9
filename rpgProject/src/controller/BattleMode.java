package controller;

import java.io.Console;
import java.util.Scanner;

import javax.management.monitor.Monitor;

import models.Unit;
import models.monster;

public class BattleMode {
	Scanner scan = new Scanner(System.in);
	Unit party[] = new Unit[4];
//	BattleMode bm = new BattleMode();
	private Guild guild = new Guild();

	public BattleMode() {//���⼭ ��� ����Ʈ �Ⱥҷ���//���⼭ ��ŸƮ
		int cnt = 0;
		for (int i = 0; i < guild.guildList.size(); i++) {
			System.out.println("s");
			party[cnt] = Guild.guildList.get(i);
			cnt++;
			System.out.println(cnt);
		}
	}

//		System.out.println(party.length);

	public void battle() {
		System.out.println("========��������=========");
		monster mob = new monster();
		spawn(mob.getName(), mob.getHp(), mob.getAtk());
		turn(mob);

	}

	public void spawn(String name, int hp, int atk) {
		System.out.println("=======[" + name + " ����]=======");
		System.out.println("=======[ü   ��:" + hp + "]=========");
		System.out.println("=======[���ݷ�:" + atk + "]========");
	}

	public void atk(int i, monster mob) {
		System.out.println(party[0].getName());
		System.out.println("=====[" + party[i].getName() + "]�� ����!======");
		int hp = mob.getHp();
		hp -= party[i].getAtt();
		System.out.println("====" + party[i].getAtt() + "�� ������ �� �������ϴ�.=====");
		mob.setAtk(hp);
	}

	public void turn(monster mob) {
		int select[] = new int[4];
		System.out.println(party.length);
		for (int i = 0; i < party.length; i++) {
			System.out.println("=======[" + party[i].getName() + "]========");
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

			}
		}

	}

}
