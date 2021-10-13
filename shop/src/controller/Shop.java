package controller;

public class Shop {

	private ItemManager im = ItemManager.instance;
	private UserManager um = UserManager.instance;
	private FileManager fm = FileManager.instance;
	private int log = -1;

	public void menu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인]\n[100.관리자] [0.종료]");
			int sel = this.um.scan.nextInt();
			if (sel == 1) {
				this.um.join();
			} else if (sel == 2) {
				this.um.withdrawal();
			} else if (sel == 3) {
				int check = um.login();
				if (check != -1) {
					this.log = check;
					loginMenu();
				}
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
				this.um.logout();
				run = false;
			} else if (sel == 2) {
				this.im.shopping(log);
			} else if (sel == 3) {
				basketmenu();
			}
		}
	}

	public void basketmenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.내장바구니] [2.삭제] [3.구입] [4.뒤로가기]");
			int sel = this.um.scan.nextInt();
			if (sel == 1) {
				this.im.basket(log);
			} else if (sel == 2) {
				this.im.remove(log);
			} else if (sel == 3) {
				this.im.pur(log);
			} else if (sel == 4) {
				run = false;
			}
		}
	}

	public void adminMenu() {// 관리자 메뉴부터 시작
		boolean run = true;
		while (run) {
			System.out.println("[1.아이템관리] [2.카테고리 관리] [3.장바구니 관리] [4.유저 관리] [5.매출] [6.파일관리] [0.뒤로가기]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				itemSetting();
			} else if (sel == 2) {
				cateSetting();
			} else if (sel == 3) {
				basketSetting();
			} else if (sel == 4) {
				userSetting();
			} else if (sel == 5) {
				im.sales();
			} else if (sel == 6) {
				fileSetting();
			}  else if (sel == 0) {
				run = false;
			}
		}
	}

	public void itemSetting() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int sel =this. um.scan.nextInt();
			if (sel == 1) {
				this.im.allItem();
			} else if (sel == 2) {
				this.im.itemAdd();
			} else if (sel == 3) {
				this.im.itemRemove();
			} else if (sel == 0) {
				run = false;
			}

		}
	}

	public void cateSetting() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				this.im.allCate();
			} else if (sel == 2) {
				this.im.cateAdd();
			} else if (sel == 3) {
				this.im.cateRemove();
			} else if (sel == 0) {
				run = false;
			}

		}
	}

	public void basketSetting() {
		boolean run = true;
		while (run) {
			System.out.println("[1.장바구니 리스트] [0.뒤로가기]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				im.allBasket();
			} else if (sel == 0) {
				run = false;
			}

		}
	}

	public void userSetting() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				this.um.allUser();
			} else if (sel == 2) {
				this.um.userAdd();
			} else if (sel == 3) {
				this.um.userRemove();
			} else if (sel == 0) {
				run = false;
			}

		}
	}
	public void fileSetting() {
		boolean run = true;
		while (run) {
			System.out.println("[1.세이브] [2.불러오기] [0.뒤로가기]");
			int sel = um.scan.nextInt();
			if (sel == 1) {
				fm.save();
				
			} else if (sel == 2) {
				this.um.userAdd();
			} else if (sel == 0) {
				run = false;
			}

		}
	}

}
