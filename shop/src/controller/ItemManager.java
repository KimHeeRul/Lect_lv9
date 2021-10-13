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
		System.out.println("아이템 번호를 입력하세요");
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

//-----------------------아이템 관리자 메뉴----------------------------
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
		System.out.print("추가할 아이템 이름:");
		String name = um.scan.next();
		int cate;
		while (true) {
			System.out.println("---------------");
			for (int i = 0; i < category.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + category.get(i));
			}
			System.out.println("---------------");
			System.out.print("추가할 아이템 카테고리 번호:");
			cate = um.scan.nextInt() - 1;
			if (cate >= category.size() && cate < 0) {
				System.out.println("존재하지않는 카테고리 입니다.");
				continue;
			} else {
				break;
			}
		}
		System.out.print("추가할 아이템 가격:");
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
			System.out.print("삭제할 아이템 번호:");
			int num = um.scan.nextInt() - 1;
			if (num < items.size() && num >= 0) {
				items.remove(num);
				break;
			}
		}
	}

//--------------------------------------
//---------------카테고리 관리자 메뉴--------------
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
		System.out.print("추가할 아이템 카테고리 이름:");
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
			System.out.print("삭제할 카테고리 번호:");
			int num = um.scan.nextInt() - 1;
			if (num < category.size() && num >= 0) {
				category.remove(num);
				break;
			}
		}
	}

//------------------------------------------
//---------------장바구니 관리자 메뉴--------------
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
//---------------매출 관리자 메뉴--------------
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

	public void remove(int log) {// 나중에 인덱스 삭제 버전도 고려
		basket(log);
		System.out.print("장바구니에서 제외할 품목명:");
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
			System.out.println("해당 상품은 존재하지않습니다.");
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
		System.out.println("총 가격:" + price);
		System.out.println("---구입완료-----");
		for (int i = 0; i < basket.size(); i++) {
			if (this.basket.get(i).getId().equals(id)) {
				this.basket.remove(i);
				i--;
			}
		}

	}

}
