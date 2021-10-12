package controller;

public class Shop {

	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;
	private int log = -1;

	public void menu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����] [2.Ż��] [3.�α���]\n[100.������] [0.����]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.withdrawal();
			} else if (sel == 3) {
				int check = um.login();
				if (check != -1) {
					this.log = check;
					loginMenu();
				}
				System.out.println("ss");
			} else if (sel == 100) {
				adminMenu();
			} else if (sel == 0) {
				run = false;
				System.out.println("����");
			}
		}
	}

	public void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.�α׾ƿ�] [2.����] [3.��ٱ��ϸ��]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				um.logout();
				run = false;
			} else if (sel == 2) {
				im.shopping(log);
			} else if (sel == 3) {
				basketmenu();
			}
		}
	}

	public void basketmenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����ٱ���] [2.����] [3.����] [4.�ڷΰ���]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				im.basket(log);
			} else if (sel == 2) {
				im.remove(log);
			} else if (sel == 3) {
				im.pur(log);
			} else if (sel == 4) {
				run = false;
			}
		}
	}

	public void adminMenu() {//������ �޴����� ����
		boolean run = true;
		while (run) {
			System.out.println("[1.�����۰���] [2.ī�װ� ����] [3.��ٱ��� ����] [4.���� ����] [0.�ڷΰ���]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
//				im.basket(log);
			} else if (sel == 2) {
//				im.remove(log);
			} else if (sel == 3) {
//				im.pur(log);
			} else if (sel == 0) {
				run = false;
			}
		}
	}
}
