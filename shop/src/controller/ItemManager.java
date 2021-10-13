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

	public int cateItem(int sel2, int sel) {
		int idx = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getCategory().equals(category.get(sel))) {
				if (sel2 == idx) {
					idx = i;
					break;
				}
				idx++;
			}
		}
		return idx;
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
		int select = cateItem(sel2, sel);
		System.out.println(items.get(select).getName());
		System.out.println(um.getUsers().get(log).getId());
		this.basket.add(new Basket(um.getUsers().get(log).getId(), items.get(select).getName()));
	}

	public void basket(int log) {
		for (int i = 0; i < basket.size(); i++) {
			if (basket.get(i).getId().equals(um.getUsers().get(log).getId())) {
				basket.get(i).print();
			}
		}
	}

//-----------------------������ ������ �޴�----------------------------
	public void allItem() {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).print();
		}
	}

	public void itemAdd() {
		System.out.println("---------------");
		for (int i = 0; i < items.size(); i++) {
			items.get(i).print();
		}
		System.out.println("---------------");
		System.out.print("�߰��� ������ �̸�:");
		String name = um.scan.next();
		int cate;
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + category.get(i));
			}
			System.out.println("---------------");
			System.out.print("�߰��� ������ ī�װ� ��ȣ:");
			cate = um.scan.nextInt() - 1;
			if (cate >= category.size() && cate < 0) {
				System.out.println("���������ʴ� ī�װ� �Դϴ�.");
				continue;
			} else {
				break;
			}
		}
		System.out.print("�߰��� ������ ����:");
		int price = um.scan.nextInt();
		items.add(new Item(name, price, category.get(cate)));

	}

	public void itemRemove() {
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < items.size(); i++) {
				System.out.print("[" + (i + 1) + "]");
				items.get(i).print();
			}
			System.out.println("---------------");
			System.out.print("������ ������ ��ȣ:");
			int num = um.scan.nextInt() - 1;
			if (num < items.size() && num >= 0) {
				items.remove(num);
				break;
			}
		}
	}

//--------------------------------------
//---------------ī�װ� ������ �޴�--------------
	public void allCate() {
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + category.get(i) + "]");
		}
	}

	public void cateAdd() {
		System.out.println("---------------");
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + category.get(i));
		}
		System.out.println("---------------");
		System.out.print("�߰��� ������ ī�װ� �̸�:");
		String name = um.scan.next();
		category.add(name);
	}

	public void cateRemove() {
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < category.size(); i++) {
				System.out.print("[" + (i + 1) + "]");
				System.out.println("[" + (i + 1) + "]" + category.get(i));
			}
			System.out.println("---------------");
			System.out.print("������ ī�װ� ��ȣ:");
			int num = um.scan.nextInt() - 1;
			if (num < category.size() && num >= 0) {
				category.remove(num);
				break;
			}
		}
	}

//------------------------------------------
//---------------��ٱ��� ������ �޴�--------------
	public void allBasket() {
		for (int i = 0; i < um.getUsers().size(); i++) {
			String id2 = um.getUsers().get(i).getId();
			System.out.println("======[" + id2 + "]=======");
			for (int j = 0; j < basket.size(); j++) {
				String id = basket.get(j).getId();
				if (id2.equals(id)) {
					System.out.println("[" + basket.get(j).getItem() + "]");

				}
			}
			System.out.println("====================");

		}
	}

//------------------------------------------
//---------------���� ������ �޴�--------------
	public void sales() {
		for (int i = 0; i < um.getUsers().size(); i++) {
			String id2 = um.getUsers().get(i).getId();
			System.out.println("======[" + id2 + "]=======");
			for (int j = 0; j < basket.size(); j++) {
				String id = basket.get(j).getId();
				if (id2.equals(id)) {
					System.out.println("[" + basket.get(j).getItem() + "]");

				}
			}
			System.out.println("====================");

		}
	}
	
//------------------------------------------

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
