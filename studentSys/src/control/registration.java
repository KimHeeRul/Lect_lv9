package control;

import java.util.ArrayList;

import model.student;
import model.subject;

public class registration extends control implements check{
//	public static registration regi = new registration();
	ArrayList<student> student = new ArrayList<student>();
	
	
	@Override
	public int nameCheck(String name) {
		int idx = -1;
		for (int i = 0; i < student.size(); i++) {
			if (student.get(i).getName().equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public void add() {
		System.out.print("����� �л��� �̸�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx == -1) {
			student.add(new student(name));
		} else {
			System.out.println("�̹� ��ϵ� �л����Դϴ�.");
		}
	}

	public void addSub() {
		System.out.print("������û�� �л� �̸�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("��û�� �����:");
			String sub = scan.next();
			student.get(idx).add(sub);
		} else {
			System.out.println("�����ϴ� �л��� �ƴմϴ�.");
		}
	}

	

	public void score() {
		System.out.print("�л��� �Է�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("������ �����");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 != -1) {
				System.out.print("�߰��� ����:");
				int score = scan.nextInt();
				student.get(idx).getSubject().get(idx2).setScore(score);
				System.out.println("��ϿϷ�!");
			} else {
				System.out.println("���������ʴ� ������Դϴ�.");
			}
		} else {
			System.out.println("���������ʴ� �л����Դϴ�.");
		}
	}

	@Override
	public int subCheck(int idx, String sub) {// ����üũ
		int idx2 = -1;
		for (int j = 0; j < student.get(idx).getSubject().size(); j++) {
			if (student.get(idx).getSubject().get(j).getSub().equals(sub)) {
				idx2 = j;
				break;
			}
		}
		return idx2;
	}
	
//	public void ModifyScore() {
//		System.out.print("�л��� �Է�:");
//		String name = scan.next();
//		int idx = check(name);
//		if (idx != -1) {
//			System.out.print("������ �����");
//			String sub = scan.next();
//			int idx2 = subCheck(idx, sub);
//			if (idx2 != -1) {
//				System.out.print("������ ����:");
//				int score = scan.nextInt();
//				student.get(idx).getSubject().get(idx2).setScore(score);
//				System.out.println("��ϿϷ�!");
//			} else {
//				System.out.println("���������ʴ� ������Դϴ�.");
//			}
//		} else {
//			System.out.println("���������ʴ� �л����Դϴ�.");
//		}
//	}

}
