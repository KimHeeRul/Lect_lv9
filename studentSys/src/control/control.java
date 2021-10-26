package control;

import java.util.ArrayList;
import java.util.Scanner;

import add.scoreAdd;
import add.studentAdd;
import add.subjectAdd;
import model.student;
import remove.studentremove;
import remove.subjectremove;

public class control {
	public static ArrayList<student> student = new ArrayList<student>();
	private static control instance = new control();
	public static scoreAdd score = new scoreAdd();
	public static studentAdd student2 = new studentAdd();
	public static subjectAdd subject = new subjectAdd();
	public static studentremove remove = new studentremove();
	public static subjectremove subremove = new subjectremove();
	public static registration regi = new registration();

	public static control getInstance() {
		return instance;
	}

	public Scanner scan = new Scanner(System.in);

	public void print() {
		for (int i = 0; i < student.size(); i++) {
			System.out.print("학생명:" + student.get(i).getName() + " ");
			for (int j = 0; j < student.get(i).getSubject().size(); j++) {
				System.out.print("과목명:" + student.get(i).getSubject().get(j).getSub() + " ");
				System.out.print("성적:" + student.get(i).getSubject().get(j).getScore() + " ");
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
		System.out.println("4)학생 퇴출");
		System.out.println("5)수강 취소");
		int sel = scan.nextInt();
		if (sel == 1) {
			student2.adds();
		} else if (sel == 2) {
			subject.adds();
		} else if (sel == 3) {
			score.adds();
		} else if (sel == 4) {
			remove.removes();
		} else if (sel == 5) {
			subremove.removes();
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
