package controller;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;

import models.Basket;
import models.Item;

public class ItemManager {
	private UserManager um = UserManager.instance;
	public static ItemManager instance = new ItemManager();
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<String> category = new ArrayList<>();
	private ArrayList<Basket> basket = new ArrayList<>();

	public ItemManager() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료");
		items.add(new Item("새우깡", 1000, category.get(0)));
		items.add(new Item("고등어", 2000, category.get(1)));
		items.add(new Item("칸쵸", 3600, category.get(0)));
		items.add(new Item("소고기", 6500, category.get(2)));
		items.add(new Item("콜라", 6500, category.get(3)));
		items.add(new Item("새우", 6500, category.get(1)));
	}

	public void shopping(int log) {
		boolean run = true;
		while (run) {
			for (int i = 0; i < category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + category.get(i));
			}
			System.out.println("카테고리 번호를 입력하세요[종료:0]");

			int sel = um.scan.nextInt() - 1;
			if (sel >= -1 && sel < category.size()) {
				if (sel == -1) {
					run = false;
				} else {
					itemShopping(sel, log);
				}

			} else {
				System.out.println("범위초과");
			}

		}

	}

	public void itemShopping(int sel, int log) {
		int cnt = 1;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getCategory().equals(category.get(sel))) {
				System.out.print("[" + cnt + "]" + "[" + items.get(i).getName() + "]");
				System.out.print("[" + items.get(i).getPrice() + "]");
				System.out.println("[" + items.get(i).getCategory() + "]");
				cnt++;
			}
		}
		System.out.println("아이템 번호를 입력하세요");
		int sel2 = um.scan.nextInt() - 1;
		System.out.println(items.get(sel2).getName());
		System.out.println(um.getUsers().get(log).getId());
		this.basket.add(new Basket(um.getUsers().get(log).getId(), items.get(sel2).getName()));
	}

	public void basket(int log) {
		for (int i = 0; i < basket.size(); i++) {
			if (basket.get(i).getId().equals(um.getUsers().get(log).getId())) {
				System.out.println(basket.toString());
			}
		}
	}

}
