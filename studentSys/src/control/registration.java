package control;

import java.util.ArrayList;

import model.student;

public class registration extends control{
//	public static registration regi = new registration();
	ArrayList<student> student = new ArrayList<student>();

	public void add() {
		System.out.print("����� �л��� �̸�:");
		String name=scan.next();
	}
	

	public void addSub() {
		System.out.print("��û�� �����:");
		String sub=scan.next();
		
	}
	
}
