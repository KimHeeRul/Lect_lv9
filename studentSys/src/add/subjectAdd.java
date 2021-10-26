package add;

import control.registration;

public class subjectAdd extends registration {

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

}
