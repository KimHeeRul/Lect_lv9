package remove;

import control.registration;

public class studentremove extends registration implements remove{

	public void removes() {
		System.out.print("퇴출 시킬 학생이름:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.println(student.get(idx).getName() + "퇴출");
			student.remove(idx);
		} else {
			System.out.println("해당 학생은 존재하지않습니다.");
		}
	}
	
	
}
