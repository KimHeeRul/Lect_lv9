package add;

import control.registration;

public class subjectAdd extends registration implements add {

	public void adds() {
		System.out.print("수강신청할 학생 이름:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("신청할 과목명:");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 == -1) {
				student.get(idx).add(sub);
				System.out.println("등록완료");
			} else {
				System.out.println("이미 등록되있는 과목입니다.");
			}
		} else {
			System.out.println("존재하는 학생이 아닙니다.");
		}
	}

}
