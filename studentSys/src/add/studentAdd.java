package add;

import control.registration;
import model.student;

public class studentAdd extends registration {
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

}
