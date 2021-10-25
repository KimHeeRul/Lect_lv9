package control;

import java.util.ArrayList;

import model.student;

public class registration extends control{
//	public static registration regi = new registration();
	ArrayList<student> student = new ArrayList<student>();

	public void add() {
		System.out.print("등록할 학생의 이름:");
		String name=scan.next();
	}
	

	public void addSub() {
		System.out.print("신청할 과목명:");
		String sub=scan.next();
		
	}
	
}
