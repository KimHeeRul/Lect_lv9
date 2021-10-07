package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Bank;
import models.User;

public class UserManager {
	// user -중앙 총 데이터
	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	
	public ArrayList<User> getUsers() {
		return users;
	}



	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}



	private UserManager() {
		User newUser = new User(0000, "admin", "0000", "admin");
		this.users.add(newUser);
	}

	

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
		if (users.get(log).getPw().equals(pw)) {
			users.remove(log);
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


	public void board() {
		for (int i = 0; i < this.users.size(); i++) {
			System.out.print("code:" + this.users.get(i).getUserCode() + "  ");
			System.out.print("id:" + this.users.get(i).getId() + " ");
			System.out.print("pw:" + this.users.get(i).getPw() + " ");
			System.out.print("name:" + this.users.get(i).getName() + " ");
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
		System.out.print("name:" + this.users.get(log).getName() + " ");
		System.out.print("accCnt:" + this.users.get(log).getAccCnt() + " ");
		for (int j = 0; j < this.users.get(log).getAccCnt(); j++) {
			System.out.print("accNo:" + this.users.get(log).getAcc().get(j).getAccNum() + ":");
			System.out.print("accMoney:" + this.users.get(log).getAcc().get(j).getMoney() + " ");
		}
		System.out.println();

	}

}
