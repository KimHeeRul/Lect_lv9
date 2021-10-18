package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Item;
import models.Player;

public class Shop {
	Scanner scan = new Scanner(System.in);
	public static ArrayList<Item> items = new ArrayList<>();

	public Shop() {
		if (this.items.size()==0) {
			init();
		}
	}

	public void init() {
		items.add(new Item(Item.Weapon, "������", 3, 1000));
		items.add(new Item(Item.Weapon, "ö��", 5, 2000));
		items.add(new Item(Item.Weapon, "�����Ǿ�", 7, 2500));

		items.add(new Item(Item.Armor, "Ƽ����", 1, 300));
		items.add(new Item(Item.Armor, "���װ���", 4, 800));
		items.add(new Item(Item.Armor, "��ö����", 7, 1500));

		items.add(new Item(Item.Ring, "������", 7, 3000));
		items.add(new Item(Item.Ring, "�ݹ���", 17, 6000));
		items.add(new Item(Item.Ring, "���̾ƹ���", 35, 20000));
	}
	public void shopMenu() {
		while (true) {
			System.out.println("=============== [�� ��] ================");
			System.out.println("[1.����] [2.����] [3.����] [0.�ڷΰ���]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				System.out.println("=========����========");
			} else if (sel == 2) {
				System.out.println("=========����========");
			} else if (sel == 3) {
				System.out.println("=========����========");
			} else {
				break;
			}
			printList(sel);
			System.out.println("������ ������ ��ȣ�� �Է��ϼ���.[0.�ڷΰ���]");
			int sel2 = scan.nextInt();
			int cnt = 1;
			for (int i = 0; i < items.size(); i++) {
				if (sel == items.get(i).getKind()) {
					if (cnt == sel2) {
						// ����-�κ��� ������ �ֱ�-������
						if (Player.money >= items.get(i).getPrice()) {
							// ������ �ֱ� �����̱���
							Inven.itemList.add(items.get(i));
							Player.money -= items.get(i).getPrice();
							System.out.println("[" + items.get(i).getName() + "] �� �����߽��ϴ�.");

						} else {
							System.out.println("������ ��尡 ���� �մϴ�.");
						}

						break;
					} else {
						cnt++;
					}
				}

			}

		}
	}

//	Item.Weapon
	public void printList(int sel) {
		int cnt = 1;
		for (int i = 0; i < items.size(); i++) {
			if (sel == items.get(i).getKind()) {
				System.out.print("[" + cnt + "��]");
				System.out.print("[�̸�:" + items.get(i).getName() + "]");
				System.out.print("[�ɷ�:" + items.get(i).getPower() + "]");
				System.out.println("[����:" + items.get(i).getPrice() + "]");
				cnt++;
			}
		}
		System.out.println("[���:" + Player.money + "]");
	}

}
