package remove;

import add.add;
import control.registration;

public class subjectremove extends registration implements remove {

	public void removes() {
		System.out.println("������ ��ҽ�ų �л���:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("����� ��������:");
			String sub = scan.next();
			int idx2=subCheck(idx,sub);
			if (idx2!=-1) {
				System.out.println(student.get(idx).getSubject().get(idx2).getSub() + "���");
				student.get(idx).getSubject().remove(idx2);
			}else {
				System.out.println("�ش������ ������������");
			}
		} else {
			System.out.println("�ش� �л��� ���������ʽ��ϴ�.");
		}
	}
	
	
}
