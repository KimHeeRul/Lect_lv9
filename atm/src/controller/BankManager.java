package controller;

import models.Bank;

public class BankManager {
	boolean isRun = true;
	private UserManager um = UserManager.instance;
	public static BankManager instance = new BankManager();

	private BankManager() {
	}

	public void run() {

		while (this.isRun) {
			System.out.println("==================");
			System.out.println(Bank.getName() + " Atm");
			System.out.println("==================");
			printMenu();
			selectMenu();
		}
	}

	private void printMenu() {
		if (Bank.log == -1) {

			System.out.println("1.로그인\n2.회원가입\n3.종료");
		} else {
			um.board();
			System.out.println("1.탈퇴\n2.계좌개설\n3.계좌 철회\n4.뱅킹\n5.파일처리\n6.관리자모드\n7.로그아웃");
		}
	}

	private void bank() {
		System.out.println("1.입금\n2.출금\n3.이체\n4.조회");
		int sel = Bank.scan.nextInt();
		if (sel == 1) {
			this.um.deposit(Bank.log);
		} else if (sel == 2) {
			this.um.outputMoney(Bank.log);
		} else if (sel == 3) {
			this.um.transfer(Bank.log);
		} else if (sel == 4) {
			this.um.pointBoard(Bank.log);
		}

	}

	private void file() {
		System.out.println("1.세이브\n2.로드");
		int sel = Bank.scan.nextInt();
		if (sel == 1) {
			this.um.save();
		} else if (sel == 2) {
			this.um.load();
		}
	}

	private void selectMenu() {
		String input = Bank.scan.next();
		try {
			int sel = Integer.parseInt(input);
			if (Bank.log == -1) {
				if (sel == 1) {
					Bank.log = this.um.login();
					if (Bank.log != -1) {
						System.out.println("로그인 성공");
					} else {
						System.out.println("로그인 실패");
					}
				} else if (sel == 2) {
					this.um.joinUser();
				} else if (sel == 3) {
					this.isRun = false;
					System.out.println("ATM종료");
				}
			} else {
				if (sel == 1) {
					Bank.log = this.um.withdrawal(Bank.log);
				} else if (sel == 2) {
					this.um.createAcc(Bank.log);
				} else if (sel == 3) {
					this.um.removeAcc(Bank.log);
				} else if (sel == 4) {
					bank();

				} else if (sel == 5) {
					file();
				} else if (sel == 6) {
					um.board();
				} else if (sel == 7) {
					Bank.log = this.um.logout();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
