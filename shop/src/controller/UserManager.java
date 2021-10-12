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
		System.out.print("ID�� �Է��� �ּ���.");
		String id = scan.next();
		int check = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				check++;
			}
		}
		if (check == 0) {
			System.out.print("PW�� �Է����ּ���.");
			String pw = scan.next();
			users.add(new User(id, pw));
		} else {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
		}
	}

	public void withdrawal() {
		System.out.print("Ż���� ID�Է�:");
		String id = scan.next();
		System.out.print("Ż���� PW�Է�:");
		String pw = scan.next();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				users.remove(i);
			} else {
				System.out.println("������ ��Ȯ�����ʽ��ϴ�.");
			}
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
					System.out.println(log);
					return i;
				} else {
					System.out.println("������ ��Ȯ�����ʽ��ϴ�.");
				}
			}
		} else {
			System.out.println("�α׾ƿ� ���¿����� �����մϴ�.");
		}
		return -1;
	}

	public void logout() {
		if (this.log != -1) {
			this.log=-1;
			System.out.println("�α׾ƿ�!");
		} else {
			System.out.println("�α��� ���¿����� �����մϴ�.");
		}
	}

	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
}
