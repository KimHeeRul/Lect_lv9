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
		System.out.print("등록할 학생의 이름:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx == -1) {
			student.add(new student(name));
		} else {
			System.out.println("이미 등록된 학생명입니다.");
		}
	}

	public void addSub() {
		System.out.print("수강신청할 학생 이름:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("신청할 과목명:");
			String sub = scan.next();
			student.get(idx).add(sub);
		} else {
			System.out.println("존재하는 학생이 아닙니다.");
		}
	}

	

	public void score() {
		System.out.print("학생명 입력:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("관리할 과목명");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 != -1) {
				System.out.print("추가할 성적:");
				int score = scan.nextInt();
				student.get(idx).getSubject().get(idx2).setScore(score);
				System.out.println("등록완료!");
			} else {
				System.out.println("존재하지않는 과목명입니다.");
			}
		} else {
			System.out.println("존재하지않는 학생명입니다.");
		}
	}

	@Override
	public int subCheck(int idx, String sub) {// 과목체크
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
//		System.out.print("학생명 입력:");
//		String name = scan.next();
//		int idx = check(name);
//		if (idx != -1) {
//			System.out.print("관리할 과목명");
//			String sub = scan.next();
//			int idx2 = subCheck(idx, sub);
//			if (idx2 != -1) {
//				System.out.print("수정할 성적:");
//				int score = scan.nextInt();
//				student.get(idx).getSubject().get(idx2).setScore(score);
//				System.out.println("등록완료!");
//			} else {
//				System.out.println("존재하지않는 과목명입니다.");
//			}
//		} else {
//			System.out.println("존재하지않는 학생명입니다.");
//		}
//	}

}
