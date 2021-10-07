package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import models.Account;
import models.Bank;
import models.User;

public class UserManager {
	private String text = "";
	// user -중앙 총 데이터
	public static UserManager instance = new UserManager();

	private UserManager() {
	}

	private ArrayList<User> users = new ArrayList<>();

	public void joinUser() {
		System.out.println("id:  ");
		String id = Bank.scan.next();
		int idx = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getId().equals(id)) {
				idx++;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("pw:  ");
			String pw = Bank.scan.next();
			System.out.println("name:  ");
			String name = Bank.scan.next();
			User newUser = new User(randomCode(), id, pw, name);
			this.users.add(newUser);
		} else {
			System.out.println("중복된 아이디입니다.");
		}

	}

	private int randomCode() {
		Random rand = new Random();
		int ran = rand.nextInt(9999) + 1000;
		// 랜덤값추출
		return ran;
	}

	public int login() {
		System.out.println("id:  ");
		String id = Bank.scan.next();

		System.out.println("pw:  ");
		String pw = Bank.scan.next();
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}

	public int withdrawal(int log) {
		System.out.println("pw:  ");
		String pw = Bank.scan.next();
		int idx = -1;
		if (users.get(log).getPw().equals(pw)) {
			users.remove(idx);
			System.out.println("회원탈퇴 완료");
			return -1;
		} else {
			System.out.println("패스워드가 다릅니다.");
			return log;
		}

	}

	public int logout() {
		System.out.println("로그아웃");
		return -1;
	}

	public void createAcc(int log) {
		Random rand = new Random();
		int cnt = users.get(log).getAccCnt();
		if (cnt < 3) {

			users.get(log).getAcc().add(new Account());
			while (true) {
				this.users.get(log).getAcc().get(cnt).setAccNum(rand.nextInt(100) + 1 + "");
				String num = this.users.get(log).getAcc().get(cnt).getAccNum();
				int check = 0;
				for (int i = 0; i < this.users.size(); i++) {// 계좌번호 중복체크
					for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
						if (this.users.get(i).getAcc().get(j).getAccNum().equals(num)) {
							check++;
						}
					}

				}
				if (check == 0) {
					users.get(log).setAccCnt(users.get(log).getAccCnt() + 1);
					break;
				}
			}
		} else {
			System.out.println("더이상 생성불가능합니다.");
		}
	}

	public void removeAcc(int log) {
		if (users.get(log).getAccCnt() > 0) {
			System.out.print("철회할 계좌번호 입력:");
			String input = Bank.scan.next();
			int idx = -1;
			for (int i = 0; i < users.get(log).getAccCnt(); i++) {
				if (users.get(log).getAcc().get(i).getAccNum().equals(input)) {
					idx = i;
				}
			}
			if (idx != -1) {
				if (users.get(log).getAcc().get(idx).getMoney() > 0) {
					System.out.println("계좌에  잔액이 남아있습니다,그럼에도 철회를 원하십니까?(yes:1,no:2");
					int input2 = Bank.scan.nextInt();
					if (input2 == 1) {
						users.get(log).getAcc().remove(idx);
						users.get(log).setAccCnt(users.get(log).getAccCnt() - 1);
					} else if (input2 == 2) {
						System.out.println("계좌 철회 취소");
					}
				} else {
					users.get(log).getAcc().remove(idx);
					users.get(log).setAccCnt(users.get(log).getAccCnt() - 1);
				}

			} else {
				System.out.println("잘못된 계좌 번호입니다.");
			}

		} else {
			System.out.println("개좌가 존재하지않습니다.");
		}
	}

	public void deposit(int log) {
		System.out.print("계좌선택:");
		String AcNum = Bank.scan.next();
		int idx = -1;
		for (int i = 0; i < users.get(log).getAccCnt(); i++) {
			if (users.get(log).getAcc().get(i).getAccNum().equals(AcNum)) {
				idx = i;
			}
		}
		if (idx != -1) {
			System.out.print("입금할  금액입력:");
			int input = Bank.scan.nextInt();
			int money = this.users.get(log).getAcc().get(idx).getMoney();
			this.users.get(log).getAcc().get(idx).setMoney(money + input);
		} else {
			System.out.println("잘못된 계좌번호입니다.");
		}
	}

	public void outputMoney(int log) {
		System.out.print("계좌선택:");
		String AcNum = Bank.scan.next();
		int idx = -1;
		for (int i = 0; i < users.get(log).getAccCnt(); i++) {
			if (users.get(log).getAcc().get(i).getAccNum().equals(AcNum)) {
				idx = i;
			}
		}
		if (idx != -1) {
			System.out.print("출금할  금액입력:");
			int input = Bank.scan.nextInt();
			int money = this.users.get(log).getAcc().get(idx).getMoney();
			if (money >= input && input > 0) {
				this.users.get(log).getAcc().get(idx).setMoney(money - input);
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
		String myAcc = "";
		int acidx = -1;
		for (int i = 0; i < this.users.get(log).getAccCnt(); i++) {
			if (this.users.get(log).getAcc().get(i).getAccNum().equals(num)) {
				acidx = i;
			}
		}
		if (acidx != -1) {
			myAcc = this.users.get(log).getAcc().get(acidx).getAccNum();
			int myMoney = this.users.get(log).getAcc().get(acidx).getMoney();
			System.out.print("이체할 계좌번호입력:");
			String input = Bank.scan.next();

			int idx = -1;
			int idx2 = -1;
			for (int i = 0; i < this.users.size(); i++) {
				for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
					if (this.users.get(i).getAcc().get(j).getAccNum().equals(input)) {
						idx = i;
						idx2 = j;
					}
				}
			}
			if (idx != -1) {
				System.out.print("이체할 금액입력:");
				int input2 = Bank.scan.nextInt();
				if (input2 <= myMoney) {
					int youMoney = this.users.get(idx).getAcc().get(idx2).getMoney();
					this.users.get(log).getAcc().get(acidx).setMoney(myMoney - input2);
					this.users.get(idx).getAcc().get(idx2).setMoney(youMoney + input2);

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

	public void save() {
		File file = new File("test.txt");
		this.text = "";
		for (int i = 0; i < this.users.size(); i++) {
			this.text += this.users.get(i).getUserCode() + "/";
			this.text += this.users.get(i).getId() + "/";
			this.text += this.users.get(i).getPw() + "/";
			this.text += this.users.get(i).getName() + "/";
			this.text += this.users.get(i).getAccCnt() + "/";
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				this.text += this.users.get(i).getAcc().get(j).getAccNum() + "/";
				this.text += this.users.get(i).getAcc().get(j).getMoney() + "/";
			}
			this.text += "\n";
		}

		try {
			FileWriter fw = new FileWriter(file);
			fw.write(this.text);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		text = "";
		for (int i = 0; i < this.users.size(); i++) {
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				this.users.get(i).setAcc(new ArrayList<>());
			}

		}

	}

	public void board() {
		for (int i = 0; i < this.users.size(); i++) {
			System.out.print("code:" + this.users.get(i).getUserCode() + "  ");
			System.out.print("id:" + this.users.get(i).getId() + " ");
			System.out.print("pw:" + this.users.get(i).getPw() + " ");
			System.out.print("accCnt:" + this.users.get(i).getAccCnt() + " ");
			for (int j = 0; j < this.users.get(i).getAccCnt(); j++) {
				System.out.print("accNo:" + this.users.get(i).getAcc().get(j).getAccNum() + ":");
				System.out.print("accMoney:" + this.users.get(i).getAcc().get(j).getMoney() + " ");
			}
			System.out.println();

		}
	}

	public void pointBoard(int log) {
		System.out.print("code:" + this.users.get(log).getUserCode() + "  ");
		System.out.print("id:" + this.users.get(log).getId() + " ");
		System.out.print("pw:" + this.users.get(log).getPw() + " ");
		System.out.print("accCnt:" + this.users.get(log).getAccCnt() + " ");
		for (int j = 0; j < this.users.get(log).getAccCnt(); j++) {
			System.out.print("accNo:" + this.users.get(log).getAcc().get(j).getAccNum() + ":");
			System.out.print("accMoney:" + this.users.get(log).getAcc().get(j).getMoney() + " ");
		}
		System.out.println();

	}

}
