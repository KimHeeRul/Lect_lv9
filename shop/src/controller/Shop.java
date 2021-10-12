package controller;

public class Shop {

	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;
	private int log = -1;

	public void menu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인]\n[100.관리자] [0.종료]");
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
				System.out.println("종료");
			}
		}
	}

	public void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.로그아웃] [2.쇼핑] [3.장바구니목록]");
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
			System.out.println("[1.내장바구니] [2.삭제] [3.구입] [4.뒤로가기]");
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

	public void adminMenu() {//관리자 메뉴부터 시작
		boolean run = true;
		while (run) {
			System.out.println("[1.아이템관리] [2.카테고리 관리] [3.장바구니 관리] [4.유저 관리] [0.뒤로가기]");
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
