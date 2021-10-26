package control;

import java.util.Scanner;

public class control {

	private static control instance = new control();
	public static registration regi = new registration();
	public static scoreAdd score = new scoreAdd();
	public static studentAdd student = new studentAdd();
	public static subjectAdd subject = new subjectAdd();

	public static control getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);

	public void print() {
		for (int i = 0; i < regi.student.size(); i++) {
			System.out.print("학생명:" + regi.student.get(i).getName() + " ");
			for (int j = 0; j < regi.student.get(i).getSubject().size(); j++) {
				System.out.print("과목명:" + regi.student.get(i).getSubject().get(j).getSub() + " ");
				System.out.print("성적:" + regi.student.get(i).getSubject().get(j).getScore() + " ");
			}
			System.out.println();
		}
	}

	public void menu() {
		print();
		System.out.println("====시스템====");
		System.out.println("1)학생등록");
		System.out.println("2)수강신청");
		System.out.println("3)성적관리");
		int sel = scan.nextInt();
		if (sel == 1) {
			student.add();
		} else if (sel == 2) {
			subject.addSub();
		} else if (sel == 3) {
			score.score();
		}

	}

//	public void scoreMenu() {
//		System.out.println("1.성적추가");
//		System.out.println("2.성적수정");
//		int sel = scan.nextInt();
//		if (sel == 1) {
//	
//		} else if (sel == 2) {
//
//		}
//	}

	public void run() {
		while (true) {
			menu();
		}
	}

}
