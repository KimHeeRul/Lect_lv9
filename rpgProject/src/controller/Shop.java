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
		items.add(new Item(Item.Weapon, "나무검", 3, 1000));
		items.add(new Item(Item.Weapon, "철검", 5, 2000));
		items.add(new Item(Item.Weapon, "레이피어", 7, 2500));

		items.add(new Item(Item.Armor, "티셔츠", 1, 300));
		items.add(new Item(Item.Armor, "가죽갑옷", 4, 800));
		items.add(new Item(Item.Armor, "강철갑옷", 7, 1500));

		items.add(new Item(Item.Ring, "은반지", 7, 3000));
		items.add(new Item(Item.Ring, "금반지", 17, 6000));
		items.add(new Item(Item.Ring, "다이아반지", 35, 20000));
	}
	public void shopMenu() {
		while (true) {
			System.out.println("=============== [상 점] ================");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				System.out.println("=========무기========");
			} else if (sel == 2) {
				System.out.println("=========갑옷========");
			} else if (sel == 3) {
				System.out.println("=========반지========");
			} else {
				break;
			}
			printList(sel);
			System.out.println("구입할 아이템 번호를 입력하세요.[0.뒤로가기]");
			int sel2 = scan.nextInt();
			int cnt = 1;
			for (int i = 0; i < items.size(); i++) {
				if (sel == items.get(i).getKind()) {
					if (cnt == sel2) {
						// 구입-인벤에 아이템 넣기-돈빼기
						if (Player.money >= items.get(i).getPrice()) {
							// 아이템 넣기 아직미구현
							Inven.itemList.add(items.get(i));
							Player.money -= items.get(i).getPrice();
							System.out.println("[" + items.get(i).getName() + "] 을 구입했습니다.");

						} else {
							System.out.println("소지한 골드가 부족 합니다.");
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
				System.out.print("[" + cnt + "번]");
				System.out.print("[이름:" + items.get(i).getName() + "]");
				System.out.print("[능력:" + items.get(i).getPower() + "]");
				System.out.println("[가격:" + items.get(i).getPrice() + "]");
				cnt++;
			}
		}
		System.out.println("[골드:" + Player.money + "]");
	}

}
