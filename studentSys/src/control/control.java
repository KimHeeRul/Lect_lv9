package control;

import java.util.Scanner;

public class control {

	private static control instance = new control();
	public static registration regi = new registration();

	public static control getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);

	public void print() {
		for (int i = 0; i < regi.student.size(); i++) {
			System.out.print("�л���:" + regi.student.get(i).getName() + " ");
			for (int j = 0; j < regi.student.get(i).getSubject().size(); j++) {
				System.out.print("�����:" + regi.student.get(i).getSubject().get(j).getSub() + " ");
				System.out.print("����:"+ regi.student.get(i).getSubject().get(j).getScore() + " ");
			}
			System.out.println();
		}
	}

	public void menu() {
		print();
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
			scoreMenu();
		}

	}
	public void scoreMenu() {
		System.out.println("1.�����߰�");
		System.out.println("2.��������");
		int sel=scan.nextInt();
		if (sel==1) {
			registration.regi.score();			
		}else if (sel==2) {
			
		}
	}
	

	public void run() {
		while (true) {
			menu();
		}
	}

}
