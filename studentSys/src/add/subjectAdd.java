package add;

import control.registration;

public class subjectAdd extends registration {

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

}
