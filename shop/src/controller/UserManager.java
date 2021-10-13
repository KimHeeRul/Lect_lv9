package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	private int log = -1;

	public void join() {
		System.out.print("ID를 입력해 주세요.");
		String id = scan.next();
		int check = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				check++;
			}
		}
		if (check == 0) {
			System.out.print("PW를 입력해주세요.");
			String pw = scan.next();
			users.add(new User(id, pw));
		} else {
			System.out.println("중복된 아이디입니다.");
		}
	}

	public void withdrawal() {
		System.out.print("탈퇴할 ID입력:");
		String id = scan.next();
		System.out.print("탈퇴할 PW입력:");
		String pw = scan.next();
		int check = -1;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				users.remove(i);
				check++;
			}
		}
		if (check == -1) {
			System.out.println("정보가 정확하지않습니다.");
		}
	}

	public int login() {
		if (this.log == -1) {
			System.out.print("ID");
			String id = scan.next();
			System.out.print("Pw");
			String pw = scan.next();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
					this.log = i;
					return i;
				}
			}
		} else {
			System.out.println("로그아웃 상태에서만 가능합니다.");
		}
		System.out.println("정보가 정확하지않습니다.");
		return -1;
	}

	public void logout() {
		if (this.log != -1) {
			this.log = -1;
			System.out.println("로그아웃!");
		} else {
			System.out.println("로그인 상태에서만 가능합니다.");
		}
	}

	// ---------------유저 관리자 메뉴--------------
	public void allUser() {
		for (int i = 0; i < users.size(); i++) {
			String id = users.get(i).getId();
			String pw = users.get(i).getPw();
			System.out.println("[ID:" + id + "][PW:" + pw + "]");
		}
	}

	public void userAdd() {
		allUser();
		join();
	}

	public void userRemove() {
		allUser();
		withdrawal();
	}

	// ------------------------------------------

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
