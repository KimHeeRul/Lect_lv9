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

	Hero hero = new Hero("���", 100, 1, 50, 1);
	ArrayList<Unit> unit = new ArrayList<>();

	public static Game getIstance() {
		return istance;
	}

	private void init() {// �ʱ� ���� ����
		unit.add(new monster("����", 25, 3, 5, 1));
		unit.add(new monster("��������", 45, 6, 10, 2));
		unit.add(new monster("��������", 65, 9, 15, 3));
		unit.add(new monsterKing("����ŷ", 100, 12, 20, 4, 50));
	}

	public void checkPoint(int check) {
		System.out.println("[���� ��:" + floor + "]");
		System.out.println("1.�ö󰣴�");
		if (check == 1) {
			System.out.println("2.ü���� ȸ���Ѵ�.");
			System.out.println("3.���⸦ ��ȭ�Ѵ�.");
		}

	}

	public int floorCheck(int floor) {
		for (int i = 0; i < unit.size(); i++) {
			if (floor == unit.get(i).getPos()) {
				System.out.println("�� ����!");
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
			System.out.println("������ �ұ�?");
			System.out.printf("1.���� 2.����(%d������)\n", hero.getCnt());
			int sel = scan.nextInt();
			if (sel == 1) {
				if (!hero.attack(temp)) {
					System.out.println("�¸��ߴ�.");
					lifeCheck = 1;
					break;
				}
			} else if (sel == 2) {// ȸ��
				hero.drink();
			}
			System.out.println();
			if (!temp.attack(hero)) {
				System.out.println("����ߴ�.");
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
		System.out.println("========�������========");
		init();
		int check = 1;
		while (true) {
			this.floor = hero.getPos();
			if (hero.getPos() > 12) {
				System.out.println("��������");
				break;
			}
			while (true) {
				checkPoint(check);
				int sel = scan.nextInt();
				if (sel == 1) {// �ö󰡱�
					check = 1;
					hero.setPos(floor += 1);
					break;
				} else if (sel == 2 && check == 1) {// ȸ��
					int hp = rand.nextInt(40) + 20;
					hero.setHp(hero.getHp() + hp);
					System.out.println(hp + "��ŭ ü����  ȸ���Ǿ����ϴ�.");
					check = 2;
				} else if (sel == 3 && check == 1) {// ��ȭ/���ݷ� ����
					System.out.println("1.���ݷ� 2.����");
					int sel2 = scan.nextInt();
					if (sel2 == 1) {
						int at = rand.nextInt(1) + 3;
						hero.setAtt(hero.getAtt()+at);
						System.out.println(at + "��ŭ ���ݷ��� �����߽��ϴ�.");
						
					} else if (sel2 == 2) {
						int df = rand.nextInt(1) + 3;
						hero.setDef(hero.getDef()+df);
						System.out.println(df + "��ŭ  ������ �����߽��ϴ�.");
					}
					check = 2;
				}
			}
			int index = floorCheck(floor);// ���� �ش� �÷ξ �����ϴ��� üũ//-1 ������
			if (index != -1) {
				boolean result = fight(index);
				if (!result) {
					break;
				}
			} else {
				System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�..");
			}
		}
	}
}
