package lv10zobieProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);
	private Hero hero;// 모험가 생성
	private ArrayList<Unit> enemy = new ArrayList<>();// 적생성

	private void init() {
		hero = new Hero("용사", 100, 50, 1, 1);
		enemy.add(new Zombie("좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new ZombieKing("좀비킹", 100, 20, 4, 12, 50));// 실드량50추가
	}

	public void map(int action) {
		System.out.println("[ 현재 층 : " + hero.getPos() + " ]");
		System.out.println("1.올라간다.");
		if (action == 1) {// 층당 1회 제한
			System.out.println("2.체력을 회복한다.");
			System.out.println("3.무기를 강화한다.");
		}
	}

	public int checkMob() {
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).getPos() == hero.getPos()) {// 적 pos랑 용사 pos랑 같을때
				System.out.println("적등장!");
				return i;
			}

		}
		return -1;
	}

	public boolean dieCheck(Unit enemy) {
		if (hero.getHp() <= 0) {// 사망
			return true;
		} else if (enemy.getHp() <= 0) {// 킬
			return true;
		}
		return false;// 전투지속
	}

	public boolean fight(Unit enemy) {
		int check = 0;
		while (true) {
			hero.stat();
			System.out.println("====VS====");
			enemy.stat();
			System.out.println("------");
			System.out.println("무엇을 할까?");
			System.out.printf("1.공격 2.물약(%d개남음)", hero.potion());
			int sel = scan.nextInt();
			if (sel == 1) {
				hero.att(enemy);// 공격
			} else if (sel == 2) {
				hero.drink();
			}
			if (dieCheck(enemy) == true) {// 몬스터 다이 체크
				check = 1;
				break;
			}
			System.out.println();
			enemy.att(hero);// 공격
			System.out.println();
			if (dieCheck(enemy) == true) {// 용사 다이체크
				check = 2;
				break;
			}
		}
		if (check == 1) {// 몬스터가 죽었을경우
			System.out.println("승리했다.");
			return true;
		} else if (check == 2) {// 용사가 죽었을경우
			System.out.println("사망했다.");
			return false;
		}
		return false;//
	}

	public void run() {
		Random rand = new Random();
		System.out.println("====모험시작=====");
		init();
		int action = 1;
		while (hero.getPos() != 12) {// 조건 pos가 12이상일때 생존성공
			map(action);
			int sel = scan.nextInt();
			if (sel == 1) {
				hero.setPos(hero.getPos() + 1);// 1층 증가
				int checkMob = checkMob();
				if (checkMob != -1) {
					boolean check = fight(enemy.get(checkMob));
					if (check == false) {// 사망
						break;
					}
				} else {
					System.out.println("아무일도 일어나지 않았다..");
				}

				action = 1;
			} else if (sel == 2 && action == 1) {
				int heal = rand.nextInt(40) + 20;
				System.out.printf("체력을 %d만큼 획복했다.\n", heal);
				action = 2;
			} else if (sel == 3 && action == 1) {
				int ranup = rand.nextInt(2);
				if (ranup == 1) {// 공격력
					int up = rand.nextInt(3) + 1;
					hero.setAtt(hero.getAtt() + up);
					System.out.println("공격력이 " + up + "만큼 증가했다!");
				} else {// 방어력
					int up = rand.nextInt(3) + 1;
					hero.setDef(hero.getDef() + up);
					System.out.println("방어력이 " + up + "만큼 증가했다!");
				}
				action = 2;
			}

		}
		System.out.println("생존에 성공했다!!");

	}
}
