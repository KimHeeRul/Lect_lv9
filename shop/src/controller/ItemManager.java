package controller;

import java.util.ArrayList;

import models.Basket;
import models.Item;
import models.sale;

public class ItemManager {
	private sale sale = new sale();
	public static ItemManager instance = new ItemManager();
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<String> category = new ArrayList<>();
	private ArrayList<Basket> basket = new ArrayList<>();
	private UserManager um = UserManager.instance;

	
	public ItemManager() {
		this.category.add("����");
		this.category.add("����");
		this.category.add("����");
		this.category.add("����");
		this.items.add(new Item("�����", 1000, this.category.get(0)));
		this.items.add(new Item("����", 2000, this.category.get(1)));
		this.items.add(new Item("ĭ��", 3600, this.category.get(0)));
		this.items.add(new Item("�Ұ��", 6500, this.category.get(2)));
		this.items.add(new Item("�ݶ�", 6500, this.category.get(3)));
		this.items.add(new Item("����", 6500, this.category.get(1)));
	}

	public void shopping(int log) {
		boolean run = true;
		while (run) {
			for (int i = 0; i < this.category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + this.category.get(i));
			}
			System.out.println("ī�װ� ��ȣ�� �Է��ϼ���[����:0]");

			int sel = this.um.scan.nextInt() - 1;
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
		int cnt = -1;
		for (int i = 0; i < this.items.size(); i++) {
			if (items.get(i).getCategory().equals(this.category.get(sel))) {
				if (sel2 == idx) {
					idx = i;
					cnt++;
					break;
				}
				idx++;
			}
		}
		if (cnt != -1) {
			return idx;
		} else {
			return -1;
		}
	}

	public void itemShopping(int sel, int log) {
		int cnt = 1;
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getCategory().equals(this.category.get(sel))) {
				System.out.print("[" + cnt + "]" + "[" + this.items.get(i).getName() + "]");
				System.out.print("[" + items.get(i).getPrice() + "]");
				System.out.println("[" + items.get(i).getCategory() + "]");
				cnt++;
			}
		}
		System.out.println("������ ��ȣ�� �Է��ϼ���");
		int sel2 = um.scan.nextInt() - 1;
		int select = cateItem(sel2, sel);
		if (select == -1) {
			System.out.println("�߸��� ��ȣ�Դϴ�.");
		} else {
			System.out.println(items.get(select).getName());
			this.um = UserManager.instance;

			System.out.println(um.getUsers().get(log).getId());
			this.basket.add(new Basket(this.um.getUsers().get(log).getId(), this.items.get(select).getName()));
		}
	}

	public void basket(int log) {
		for (int i = 0; i < this.basket.size(); i++) {
			if (this.basket.get(i).getId().equals(this.um.getUsers().get(log).getId())) {
				this.basket.get(i).print();
			}
		}
	}

//-----------------------������ ������ �޴�----------------------------
	public void allItem() {
		for (int i = 0; i < this.items.size(); i++) {
			this.items.get(i).print();
		}
	}

	public void itemAdd() {
		System.out.println("---------------");
		for (int i = 0; i < this.items.size(); i++) {
			this.items.get(i).print();
		}
		System.out.println("---------------");
		System.out.print("�߰��� ������ �̸�:");
		String name = this.um.scan.next();
		int cate;
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < this.category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + this.category.get(i));
			}
			System.out.println("---------------");
			System.out.print("�߰��� ������ ī�װ� ��ȣ:");
			cate = this.um.scan.nextInt() - 1;
			if (cate >= this.category.size() && cate < 0) {
				System.out.println("���������ʴ� ī�װ� �Դϴ�.");
				continue;
			} else {
				break;
			}
		}
		System.out.print("�߰��� ������ ����:");
		int price = this.um.scan.nextInt();
		this.items.add(new Item(name, price, this.category.get(cate)));

	}

	public void itemRemove() {
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < this.items.size(); i++) {
				System.out.print("[" + (i + 1) + "]");
				this.items.get(i).print();
			}
			System.out.println("---------------");
			System.out.print("������ ������ ��ȣ:");
			int num = this.um.scan.nextInt() - 1;
			if (num < this.items.size() && num >= 0) {
				this.items.remove(num);
				break;
			}
		}
	}

//--------------------------------------
//---------------ī�װ� ������ �޴�--------------
	public void allCate() {
		for (int i = 0; i < this.category.size(); i++) {
			System.out.println("[" + this.category.get(i) + "]");
		}
	}

	public void cateAdd() {
		System.out.println("---------------");
		for (int i = 0; i < this.category.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + this.category.get(i));
		}
		System.out.println("---------------");
		System.out.print("�߰��� ������ ī�װ� �̸�:");
		String name = um.scan.next();
		this.category.add(name);
	}

	public void cateRemove() {
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < this.category.size(); i++) {
				System.out.print("[" + (i + 1) + "]");
				System.out.println("[" + (i + 1) + "]" + this.category.get(i));
			}
			System.out.println("---------------");
			System.out.print("������ ī�װ� ��ȣ:");
			int num = this.um.scan.nextInt() - 1;
			if (num < this.category.size() && num >= 0) {
				this.category.remove(num);
				break;
			}
		}
	}

//------------------------------------------
//---------------��ٱ��� ������ �޴�--------------
	public void allBasket() {
		for (int i = 0; i < this.um.getUsers().size(); i++) {
			String id2 = this.um.getUsers().get(i).getId();
			System.out.println("======[" + id2 + "]=======");
			for (int j = 0; j < basket.size(); j++) {
				String id = basket.get(j).getId();
				if (id2.equals(id)) {
					System.out.println("[" + this.basket.get(j).getItem() + "]");

				}
			}
			System.out.println("====================");

		}
	}

//------------------------------------------
//---------------����  ������ �޴�--------------
	public void sales() {
		System.out.println("==========�ȸ� ��ǰ=============");
		for (int i = 0; i < this.items.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < sale.getItemSales().size(); j++) {
				if (this.items.get(i).getName().equals(this.sale.getItemSales().get(j))) {
					cnt++;
				}
			}
			System.out.println(this.items.get(i).getName() + " :" + cnt + "��");
		}
		System.out.println("============================");
		System.out.println("�� ����:" + sale.getSales());
	}

//------------------------------------------

	public void remove(int log) {// ���߿� �ε��� ���� ������ ���
		basket(log);
		System.out.print("��ٱ��Ͽ��� ������ ǰ���:");
		String sel = this.um.scan.next();
		int idx = -1;
		for (int i = 0; i < this.basket.size(); i++) {
			if (this.basket.get(i).getItem().equals(sel)) {
				idx = i;
			}
		}
		if (idx != -1) {
			this.basket.remove(idx);
		} else {
			System.out.println("�ش� ��ǰ�� ���������ʽ��ϴ�.");
		}
	}

	public void basketRemove(String id) {
		for (int i = 0; i < this.basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {
				this.basket.remove(i);
				i--;
			}
		}
	}

	public void pur(int log) {
		basket(log);
		System.out.println("====================");
		int price = 0;
		String id = this.um.getUsers().get(log).getId();
		for (int i = 0; i < this.basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {

				for (int j = 0; j < this.items.size(); j++) {
					if (this.basket.get(i).getItem().equals(this.items.get(j).getName())) {
						price += this.items.get(j).getPrice();
						this.sale.getItemSales().add(this.items.get(j).getName());
						break;
					}
				}
			}
		}
		System.out.println("�� ����:" + price);
		System.out.println("---���ԿϷ�-----");
		int sales = sale.getSales();
		this.sale.setSales(sales + price);

		for (int i = 0; i < this.basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {
				this.basket.remove(i);
				i--;
			}
		}

	}

}
