package controller;

import java.util.Random;

import models.Account;
import models.Bank;

public class AccountManager {
	private UserManager um = UserManager.instance;
	public static AccountManager instance = new AccountManager();

	private AccountManager() {
	}

	public void createAcc(int log) {
		Random rand = new Random();
		int cnt = um.getUsers().get(log).getAccCnt();
		if (cnt < 3) {

			um.getUsers().get(log).getAcc().add(new Account());
			while (true) {
				this.um.getUsers().get(log).getAcc().get(cnt).setAccNum(rand.nextInt(100) + 1 + "");
				String num = this.um.getUsers().get(log).getAcc().get(cnt).getAccNum();
				int check = 0;
				for (int i = 0; i < this.um.getUsers().size(); i++) {// 계좌번호 중복체크
					for (int j = 0; j < this.um.getUsers().get(i).getAccCnt(); j++) {
						if (this.um.getUsers().get(i).getAcc().get(j).getAccNum().equals(num)) {
							check++;
						}
					}

				}
				if (check == 0) {
					um.getUsers().get(log).setAccCnt(um.getUsers().get(log).getAccCnt() + 1);
					break;
				}
			}
		} else {
			System.out.println("더이상 생성불가능합니다.");
		}
	}

	public void removeAcc(int log) {
		if (um.getUsers().get(log).getAccCnt() > 0) {
			System.out.print("철회할 계좌번호 입력:");
			String input = Bank.scan.next();
			int idx = -1;
			for (int i = 0; i < um.getUsers().get(log).getAccCnt(); i++) {
				if (um.getUsers().get(log).getAcc().get(i).getAccNum().equals(input)) {
					idx = i;
				}
			}
			if (idx != -1) {
				if (um.getUsers().get(log).getAcc().get(idx).getMoney() > 0) {
					System.out.println("계좌에  잔액이 남아있습니다,그럼에도 철회를 원하십니까?(yes:1,no:2");
					int input2 = Bank.scan.nextInt();
					if (input2 == 1) {
						um.getUsers().get(log).getAcc().remove(idx);
						um.getUsers().get(log).setAccCnt(um.getUsers().get(log).getAccCnt() - 1);
					} else if (input2 == 2) {
						System.out.println("계좌 철회 취소");
					}
				} else {
					um.getUsers().get(log).getAcc().remove(idx);
					um.getUsers().get(log).setAccCnt(um.getUsers().get(log).getAccCnt() - 1);
				}

			} else {
				System.out.println("잘못된 계좌 번호입니다.");
			}

		} else {
			System.out.println("개좌가 존재하지않습니다.");
		}
	}

	public void deposit(int log) {
		System.out.print("계좌선택(accNo):");
		String AcNum = Bank.scan.next();
		int idx = -1;
		for (int i = 0; i < um.getUsers().get(log).getAccCnt(); i++) {
			if (um.getUsers().get(log).getAcc().get(i).getAccNum().equals(AcNum)) {
				idx = i;
			}
		}
		if (idx != -1) {
			System.out.print("입금할  금액입력:");
			int input = Bank.scan.nextInt();
			int money = this.um.getUsers().get(log).getAcc().get(idx).getMoney();
			this.um.getUsers().get(log).getAcc().get(idx).setMoney(money + input);
		} else {
			System.out.println("잘못된 계좌번호입니다.");
		}
	}

	public void outputMoney(int log) {
		System.out.print("계좌선택:");
		String AcNum = Bank.scan.next();
		int idx = -1;
		for (int i = 0; i < um.getUsers().get(log).getAccCnt(); i++) {
			if (um.getUsers().get(log).getAcc().get(i).getAccNum().equals(AcNum)) {
				idx = i;
			}
		}
		if (idx != -1) {
			System.out.print("출금할  금액입력:");
			int input = Bank.scan.nextInt();
			int money = this.um.getUsers().get(log).getAcc().get(idx).getMoney();
			if (money >= input && input > 0) {
				this.um.getUsers().get(log).getAcc().get(idx).setMoney(money - input);
			} else {
				System.out.println("소지한 금액이 부족하거나 입력값이 잘못되었습니다.");
			}

		} else {
			System.out.println("잘못된 계좌번호입니다.");
		}
	}

	public void transfer(int log) {
		System.out.print("내 계좌선택:");
		String num = Bank.scan.next();
//		String myAcc = "";
		int acidx = -1;
		for (int i = 0; i < this.um.getUsers().get(log).getAccCnt(); i++) {
			if (this.um.getUsers().get(log).getAcc().get(i).getAccNum().equals(num)) {
				acidx = i;
			}
		}
		if (acidx != -1) {
//			myAcc = this.um.getUsers().get(log).getAcc().get(acidx).getAccNum();
			int myMoney = this.um.getUsers().get(log).getAcc().get(acidx).getMoney();
			System.out.print("이체할 계좌번호입력:");
			String input = Bank.scan.next();

			int idx = -1;
			int idx2 = -1;
			for (int i = 0; i < this.um.getUsers().size(); i++) {
				for (int j = 0; j < this.um.getUsers().get(i).getAccCnt(); j++) {
					if (this.um.getUsers().get(i).getAcc().get(j).getAccNum().equals(input)) {
						idx = i;
						idx2 = j;
					}
				}
			}
			if (idx != -1) {
				System.out.print("이체할 금액입력:");
				int input2 = Bank.scan.nextInt();
				if (input2 <= myMoney) {
					int youMoney = this.um.getUsers().get(idx).getAcc().get(idx2).getMoney();
					this.um.getUsers().get(log).getAcc().get(acidx).setMoney(myMoney - input2);
					this.um.getUsers().get(idx).getAcc().get(idx2).setMoney(youMoney + input2);

				} else {
					System.out.println("이체할 금액보다 소지금액이 적습니다.");
				}
			} else {
				System.out.println("계좌번호가 잘못되었습니다");
			}

		} else {
			System.out.println("잘못된 계좌번호");
		}

	}

	public void pointBoard(int log) {
		System.out.print("code:" + this.um.getUsers().get(log).getUserCode() + "  ");
		System.out.print("id:" + this.um.getUsers().get(log).getId() + " ");
		System.out.print("pw:" + this.um.getUsers().get(log).getPw() + " ");
		System.out.print("name:" + this.um.getUsers().get(log).getName() + " ");
		System.out.print("accCnt:" + this.um.getUsers().get(log).getAccCnt() + " ");
		for (int j = 0; j < this.um.getUsers().get(log).getAccCnt(); j++) {
			System.out.print("accNo:" + this.um.getUsers().get(log).getAcc().get(j).getAccNum() + ":");
			System.out.print("accMoney:" + this.um.getUsers().get(log).getAcc().get(j).getMoney() + " ");
		}
		System.out.println();

	}

}
