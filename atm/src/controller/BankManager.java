package controller;

import models.Bank;

public class BankManager {
	boolean isRun = true;
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	private FileManager fm = FileManager.instance;
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

			System.out.println("1.로그인\n2.회원가입\n3.종료\n4.파일처리");
		} else {
			um.board();
			System.out.print("1.탈퇴\n2.계좌개설\n3.계좌 철회\n4.뱅킹\n5.로그아웃");
			if (Bank.log == 0) {
				System.out.println("\n6.관리자모드");
			}
		}
	}

	private void bank() {
		System.out.println("1.입금\n2.출금\n3.이체\n4.조회\n5.대표계좌 변경");
		int sel = Bank.scan.nextInt();
		if (sel == 1) {
			this.am.deposit(Bank.log);
		} else if (sel == 2) {
			this.am.outputMoney(Bank.log);
		} else if (sel == 3) {
			this.am.transfer(Bank.log);
		} else if (sel == 4) {
			this.am.pointBoard(Bank.log);
		} else if (sel == 5) {
			this.am.repAccount(Bank.log);
		}

	}

	private void file() {
		System.out.println("1.세이브\n2.로드");
		int sel = Bank.scan.nextInt();
		if (sel == 1) {
			this.fm.save();
		} else if (sel == 2) {
			this.fm.load();
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
				} else if (sel == 4) {
					file();
					um.board();
				}
			} else {
				if (sel == 1) {
					Bank.log = this.um.withdrawal(Bank.log);
				} else if (sel == 2) {
					this.am.createAcc(Bank.log);
				} else if (sel == 3) {
					this.am.removeAcc(Bank.log);
				} else if (sel == 4) {
					bank();
				} else if (sel == 5) {
					Bank.log = this.um.logout();
				} else if (sel == 6&&Bank.log == 0) {
					um.board();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
