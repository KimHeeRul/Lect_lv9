package controller;

import java.util.Random;
import java.util.Scanner;

import models.Player;
import models.Unit;
import models.monster;

public class BattleMode {
	Scanner scan = new Scanner(System.in);
//	ArrayList<Unit> party=new ArrayList<Unit>()
	Unit party[] = new Unit[4];
	private Guild guild = Guild.guild;
	private Random ran = new Random();

	public BattleMode() {// 여기서 길드 리스트 안불러짐//여기서 스타트
		int cnt = 0;
		for (int i = 0; i < guild.guildList.size(); i++) {
			if (guild.guildList.get(i).isParty()) {
				party[cnt] = guild.guildList.get(i);
				cnt++;
			}

		}
	}

	public void battle() {
		System.out.println("★★★★★★★전투시작★★★★★★★");
		monster mob = new monster();
		spawn(mob.getName(), mob.getHp(), mob.getAtk());
		while (true) {
			turn(mob);
			if (mob.getHp() > 0) {
				mobstat(mob);
				mobatk(mob);
				if (party.length == 0) {
					break;
				}
			} else {
				clear(mob);
				break;
			}
		}

	}

	public void clear(monster mob) {
		System.out.println();
		System.out.println("=====[" + mob.getName() + "]를 처치했습니다======");
		for (int i = 0; i < party.length; i++) {
			int exp = party[i].getExp();
			int expPlus = mob.getAtk();
			party[i].setExp(exp + expPlus);
			System.out.println("----" + party[i].getName() +" "+ expPlus + " EXP 획득!---------");
		}
		int money = ran.nextInt(900) + 100;
		Player.money += money;
		System.out.println("=====골드 " + money + "G 획득!=======");
		System.out.println();
		level();

	}

	public void level() {
		for (int i = 0; i < party.length; i++) {
			if (party[i].getExp() >= (party[i].getLevel() * 10)) {
				party[i].setExp(party[i].getExp() - (party[i].getLevel() * 10));
				party[i].setLevel(party[i].getLevel() + 1);
				party[i].setMaxHp(party[i].getMaxHp() + (party[i].getMaxHp() / 10));
				party[i].setHp(party[i].getMaxHp());
				System.out.println(party[i].getName() + "은(는) 레벨이 올랐다!");
				i--;
			}

		}

	}

	public void death() {
		for (int i = 0; i < party.length; i++) {
			if (!party[i].isLife()) {
				Player.inven.recoveryItem(i);
				guild.guildList.remove(i);
				for (int j = 0; j < guild.guildList.size(); j++) {// 차순위 에게 파티 넘기기
					if (guild.guildList.get(j).isParty() == false) {
						guild.guildList.get(j).setParty(true);
						break;
					}
				}
			}
		}
	}

	public void mobatk(monster mob) {
		System.out.println("=====[" + mob.getName() + "]의 공격!======");
		int num = ran.nextInt(party.length);
		int hp = party[num].getHp() - (mob.getAtk()-party[num].getDef()*2);
		party[num].setHp(hp);
		System.out.println("[" + party[num].getName() + "이(가) " + (mob.getAtk()-party[num].getDef()*2) + "의 피해를 입었습니다.]");
		healthCheck(num);
	}

	public void healthCheck(int i) {
		if (party[i].getHp() <= 0) {
			System.out.println(party[i].getName() + "이 사망했습니다.");
			party[i].setLife(false);
			death();
			
			
			Unit temp[] = new Unit[party.length - 1];
			int cnt = 0;
			for (int j = 0; j < party.length; j++) {
				if (party[j].isLife()) {
					temp[cnt] = party[j];
					cnt++;
				}
			}
			this.party = new Unit[temp.length];
			for (int j = 0; j < temp.length; j++) {
				party[j] = temp[j];
			}
			System.out.println(party.length);
			if (party.length == 0) {
				System.out.println("전멸");
				death();
			}

		}

	}

	public void mobstat(monster mob) {
		System.out.println();
		System.out.println("=======[" + mob.getName() + " 의 남은체력]=======");
		System.out.println("------[체   력:" + mob.getHp() + "]-------");
		System.out.println("============================");
		System.out.println();
	}

	public void spawn(String name, int hp, int atk) {
		System.out.println("=======[" + name + " 등장]=======");
		System.out.println("------[체   력:" + hp + "]-------");
		System.out.println("------[공격력:" + atk + " ]-------");
	}

	public void atk(int i, monster mob) {
		System.out.println("=====[" + party[i].getName() + "]의 공격!======");
		int hp = mob.getHp();
		hp -= party[i].getAtt();
		mob.setHp(hp);
		System.out.println("====" + party[i].getAtt() + "의 데미지 를 입혔습니다=====");
	}

	public void heal(int i, monster mob) {
		int hp = party[i].getHp();
		int heal = party[i].getMaxHp() / 4;
		if ((hp + heal) > party[i].getMaxHp()) {
			party[i].setHp(party[i].getMaxHp());
		} else {
			party[i].setHp(hp + heal);
		}
		System.out.println("===" + party[i].getName() + "이(가) 체력을 회복했습니다.");
	}

	public void turn(monster mob) {
		int select[] = new int[4];
		for (int i = 0; i < party.length; i++) {
			System.out.println("=======[" + party[i].getName() + "]========");
			System.out.println("체   력:" + party[i].getHp());
			System.out.println("공격력:" + party[i].getAtt());
			System.out.println("[1.공격] [2.힐]");
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
