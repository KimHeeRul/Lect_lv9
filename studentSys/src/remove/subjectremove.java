package remove;

import add.add;
import control.registration;

public class subjectremove extends registration implements remove {

	public void removes() {
		System.out.println("수강을 취소시킬 학생명:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("취소할 수강과목:");
			String sub = scan.next();
			int idx2=subCheck(idx,sub);
			if (idx2!=-1) {
				System.out.println(student.get(idx).getSubject().get(idx2).getSub() + "취소");
				student.get(idx).getSubject().remove(idx2);
			}else {
				System.out.println("해당과목은 존재하지않음");
			}
		} else {
			System.out.println("해당 학생은 존재하지않습니다.");
		}
	}
	
	
}
