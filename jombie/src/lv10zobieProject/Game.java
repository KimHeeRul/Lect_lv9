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
	private Hero hero;// ���谡 ����
	private ArrayList<Unit> enemy = new ArrayList<>();// ������

	private void init() {
		hero = new Hero("���", 100, 50, 1, 1);
		enemy.add(new Zombie("����", 25, 5, 1, 3));
		enemy.add(new Zombie("��������", 45, 10, 2, 6));
		enemy.add(new Zombie("��������", 65, 15, 3, 9));
		enemy.add(new ZombieKing("����ŷ", 100, 20, 4, 12, 50));// �ǵ差50�߰�
	}

	public void map(int action) {
		System.out.println("[ ���� �� : " + hero.getPos() + " ]");
		System.out.println("1.�ö󰣴�.");
		if (action == 1) {// ���� 1ȸ ����
			System.out.println("2.ü���� ȸ���Ѵ�.");
			System.out.println("3.���⸦ ��ȭ�Ѵ�.");
		}
	}

	public int checkMob() {
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).getPos() == hero.getPos()) {// �� pos�� ��� pos�� ������
				System.out.println("������!");
				return i;
			}

		}
		return -1;
	}

	public boolean dieCheck(Unit enemy) {
		if (hero.getHp() <= 0) {// ���
			return true;
		} else if (enemy.getHp() <= 0) {// ų
			return true;
		}
		return false;// ��������
	}

	public boolean fight(Unit enemy) {
		int check = 0;
		while (true) {
			hero.stat();
			System.out.println("====VS====");
			enemy.stat();
			System.out.println("------");
			System.out.println("������ �ұ�?");
			System.out.printf("1.���� 2.����(%d������)", hero.potion());
			int sel = scan.nextInt();
			if (sel == 1) {
				hero.att(enemy);// ����
			} else if (sel == 2) {
				hero.drink();
			}
			if (dieCheck(enemy) == true) {// ���� ���� üũ
				check = 1;
				break;
			}
			System.out.println();
			enemy.att(hero);// ����
			System.out.println();
			if (dieCheck(enemy) == true) {// ��� ����üũ
				check = 2;
				break;
			}
		}
		if (check == 1) {// ���Ͱ� �׾������
			System.out.println("�¸��ߴ�.");
			return true;
		} else if (check == 2) {// ��簡 �׾������
			System.out.println("����ߴ�.");
			return false;
		}
		return false;//
	}

	public void run() {
		Random rand = new Random();
		System.out.println("====�������=====");
		init();
		int action = 1;
		while (hero.getPos() != 12) {// ���� pos�� 12�̻��϶� ��������
			map(action);
			int sel = scan.nextInt();
			if (sel == 1) {
				hero.setPos(hero.getPos() + 1);// 1�� ����
				int checkMob = checkMob();
				if (checkMob != -1) {
					boolean check = fight(enemy.get(checkMob));
					if (check == false) {// ���
						break;
					}
				} else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�..");
				}

				action = 1;
			} else if (sel == 2 && action == 1) {
				int heal = rand.nextInt(40) + 20;
				System.out.printf("ü���� %d��ŭ ȹ���ߴ�.\n", heal);
				action = 2;
			} else if (sel == 3 && action == 1) {
				int ranup = rand.nextInt(2);
				if (ranup == 1) {// ���ݷ�
					int up = rand.nextInt(3) + 1;
					hero.setAtt(hero.getAtt() + up);
					System.out.println("���ݷ��� " + up + "��ŭ �����ߴ�!");
				} else {// ����
					int up = rand.nextInt(3) + 1;
					hero.setDef(hero.getDef() + up);
					System.out.println("������ " + up + "��ŭ �����ߴ�!");
				}
				action = 2;
			}

		}
		System.out.println("������ �����ߴ�!!");

	}
}
