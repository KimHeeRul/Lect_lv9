package control;

import java.util.Scanner;

import model.student;

public class control {

	private static control instance = new control();
	public static registration regi = new registration();

	public static control getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);

	public void menu() {
		System.out.println("====�ý���====");
		System.out.println("1)�л����");
		System.out.println("2)������û");
		System.out.println("3)��������");
		int sel = scan.nextInt();
		if (sel == 1) {
			registration.regi.add();
		} else if (sel == 2) {
			registration.regi.addSub();
		} else if (sel == 3) {

		}

	}

	public void run() {
		menu();
	}

}
