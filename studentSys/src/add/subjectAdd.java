package add;

import control.registration;

public class subjectAdd extends registration implements add {

	public void adds() {
		System.out.print("������û�� �л� �̸�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("��û�� �����:");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 == -1) {
				student.get(idx).add(sub);
				System.out.println("��ϿϷ�");
			} else {
				System.out.println("�̹� ��ϵ��ִ� �����Դϴ�.");
			}
		} else {
			System.out.println("�����ϴ� �л��� �ƴմϴ�.");
		}
	}

}
