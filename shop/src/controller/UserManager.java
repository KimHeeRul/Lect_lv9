package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Basket;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	private int log = -1;
	static Scanner scan = new Scanner(System.in);
	private ItemManager im = ItemManager.instance;

	public void join() {
		System.out.print("ID�� �Է��� �ּ���.");
		String id = scan.next();
		int check = 0;
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getId().equals(id)) {
				check++;
			}
		}
		if (check == 0) {
			System.out.print("PW�� �Է����ּ���.");
			String pw = scan.next();
			this.users.add(new User(id, pw));
		} else {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
		}
	}

	public void withdrawal() {
		System.out.print("Ż���� ID�Է�:");
		String id = scan.next();
		System.out.print("Ż���� PW�Է�:");
		String pw = scan.next();
		int check = -1;
		for (int i = 0; i < users.size(); i++) {
			if (this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
				this.im.basketRemove(id);
				this.users.remove(i);
				check++;
			}
		}
		if (check == -1) {
			System.out.println("������ ��Ȯ�����ʽ��ϴ�.");
		}
	}

	public int login() {
		if (this.log == -1) {
			System.out.print("ID");
			String id = scan.next();
			System.out.print("Pw");
			String pw = scan.next();
			for (int i = 0; i < this.users.size(); i++) {
				if (this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
					this.log = i;
					return i;
				}
			}
		} else {
			System.out.println("�α׾ƿ� ���¿����� �����մϴ�.");
		}
		System.out.println("������ ��Ȯ�����ʽ��ϴ�.");
		return -1;
	}

	public void logout() {
		if (this.log != -1) {
			this.log = -1;
			System.out.println("�α׾ƿ�!");
		} else {
			System.out.println("�α��� ���¿����� �����մϴ�.");
		}
	}

	// ---------------���� ������ �޴�--------------
	public void allUser() {
		for (int i = 0; i < this.users.size(); i++) {
			String id = this.users.get(i).getId();
			String pw = this.users.get(i).getPw();
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
		return this.users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
