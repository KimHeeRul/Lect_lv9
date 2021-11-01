package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Hero;
import models.Unit;
import models.monster;
import models.monsterKing;

public class Game {
	private int floor = 1;
	private static Game istance = new Game();
	Scanner scan = new Scanner(System.in);

	Hero hero = new Hero("용사", 100, 1, 50, 1);
	ArrayList<Unit> unit = new ArrayList<>();

	public static Game getIstance() {
		return istance;
	}

	private void init() {// 초기 유닛 세팅
		unit.add(new monster("좀비", 25, 3, 5, 1));
		unit.add(new monster("힘쌘좀비", 45, 6, 10, 2));
		unit.add(new monster("정예좀비", 65, 9, 15, 3));
		unit.add(new monsterKing("좀비킹", 100, 12, 20, 4, 50));
	}

	public void checkPoint(int check) {
		System.out.println("[현재 층:" + floor + "]");
		System.out.println("1.올라간다");
		if (check == 1) {
			System.out.println("2.체력을 회복한다.");
			System.out.println("3.무기를 강화한다.");
		}

	}

	public int floorCheck(int floor) {
		for (int i = 0; i < unit.size(); i++) {
			if (floor == unit.get(i).getPos()) {
				System.out.println("적 등장!");
				return i;
			}
		}
		return -1;
	}

	public boolean fight(int index) {
		Unit temp = unit.get(index);
		int lifeCheck = 0;
		while (true) {
			hero.stat();
			System.out.println("====VS====");
			unit.get(index).stat();
			System.out.println("--------");
			System.out.println("무엇을 할까?");
			System.out.printf("1.공격 2.물약(%d개남음)\n", hero.getCnt());
			int sel = scan.nextInt();
			if (sel == 1) {
				if (!hero.attack(temp)) {
					System.out.println("승리했다.");
					lifeCheck = 1;
					break;
				}
			} else if (sel == 2) {// 회복
				hero.drink();
			}
			System.out.println();
			if (!temp.attack(hero)) {
				System.out.println("사망했다.");
				lifeCheck = 2;
				break;
			}

		}
		if (lifeCheck == 1) {
			return true;
		} else if (lifeCheck == 2) {
			return false;
		}
		return false;
	}

	public void run() {
		Random rand = new Random();
		System.out.println("========모험시작========");
		init();
		int check = 1;
		while (true) {
			this.floor = hero.getPos();
			if (hero.getPos() > 12) {
				System.out.println("생존성공");
				break;
			}
			while (true) {
				checkPoint(check);
				int sel = scan.nextInt();
				if (sel == 1) {// 올라가기
					check = 1;
					hero.setPos(floor += 1);
					break;
				} else if (sel == 2 && check == 1) {// 회복
					int hp = rand.nextInt(40) + 20;
					hero.setHp(hero.getHp() + hp);
					System.out.println(hp + "만큼 체력이  회복되었습니다.");
					check = 2;
				} else if (sel == 3 && check == 1) {// 강화/공격력 방어력
					System.out.println("1.공격력 2.방어력");
					int sel2 = scan.nextInt();
					if (sel2 == 1) {
						int at = rand.nextInt(1) + 3;
						hero.setAtt(hero.getAtt()+at);
						System.out.println(at + "만큼 공격력이 증가했습니다.");
						
					} else if (sel2 == 2) {
						int df = rand.nextInt(1) + 3;
						hero.setDef(hero.getDef()+df);
						System.out.println(df + "만큼  방어력이 증가했습니다.");
					}
					check = 2;
				}
			}
			int index = floorCheck(floor);// 몹이 해당 플로어에 존재하는지 체크//-1 은없음
			if (index != -1) {
				boolean result = fight(index);
				if (!result) {
					break;
				}
			} else {
				System.out.println("아무일도 일어나지 않았다..");
			}
		}
	}
}
