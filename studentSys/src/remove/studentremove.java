package remove;

import control.registration;

public class studentremove extends registration implements remove{

	public void removes() {
		System.out.print("���� ��ų �л��̸�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.println(student.get(idx).getName() + "����");
			student.remove(idx);
		} else {
			System.out.println("�ش� �л��� ���������ʽ��ϴ�.");
		}
	}
	
	
}
