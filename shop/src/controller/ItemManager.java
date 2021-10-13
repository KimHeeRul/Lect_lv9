package controller;

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
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("����");
		items.add(new Item("�����", 1000, category.get(0)));
		items.add(new Item("����", 2000, category.get(1)));
		items.add(new Item("ĭ��", 3600, category.get(0)));
		items.add(new Item("�Ұ��", 6500, category.get(2)));
		items.add(new Item("�ݶ�", 6500, category.get(3)));
		items.add(new Item("����", 6500, category.get(1)));
	}

	public void shopping(int log) {
		boolean run = true;
		while (run) {
			for (int i = 0; i < category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + category.get(i));
			}
			System.out.println("ī�װ� ��ȣ�� �Է��ϼ���[����:0]");

			int sel = um.scan.nextInt() - 1;
			if (sel >= -1 && sel < category.size()) {
				if (sel == -1) {
					run = false;
				} else {
					itemShopping(sel, log);
				}

			} else {
				System.out.println("�����ʰ�");
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
		System.out.println("������ ��ȣ�� �Է��ϼ���");
		int sel2 = um.scan.nextInt() - 1;
		System.out.println(items.get(sel2).getName());
		System.out.println(um.getUsers().get(log).getId());
		this.basket.add(new Basket(um.getUsers().get(log).getId(), items.get(sel2).getName()));
	}

	public void basket(int log) {
		for (int i = 0; i < basket.size(); i++) {
			if (basket.get(i).getId().equals(um.getUsers().get(log).getId())) {
				basket.get(i).print();
			}
		}
	}

	public void allBasket() {
		System.out.println(basket.size());
		for (int i = 0; i < basket.size(); i++) {
			basket.get(i).print();
			System.out.println("s");
		}
	}

	public void remove(int log) {// ���߿� �ε��� ���� ������ ���
		basket(log);
		System.out.print("��ٱ��Ͽ��� ������ ǰ���:");
		String sel = um.scan.next();
		int idx = -1;
		for (int i = 0; i < basket.size(); i++) {
			if (basket.get(i).getItem().equals(sel)) {
				idx = i;
			}
		}
		if (idx != -1) {
			basket.remove(idx);
		} else {
			System.out.println("�ش� ��ǰ�� ���������ʽ��ϴ�.");
		}
	}

	public void pur(int log) {
		basket(log);
		System.out.println("====================");
		int price = 0;
		String id = um.getUsers().get(log).getId();
		for (int i = 0; i < basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {
				price += this.items.get(i).getPrice();
			}
		}
		System.out.println("�� ����:" + price);
		System.out.println("---���ԿϷ�-----");
		for (int i = 0; i < basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {
				this.basket.remove(i);
				i--;
			}
		}

	}

}
