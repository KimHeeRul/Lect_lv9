package control;

public class scoreAdd extends registration {
	public void score() {
		System.out.print("�л��� �Է�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("������ �����");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 != -1) {
				System.out.print("�߰��� ����:");
				int score = scan.nextInt();
				student.get(idx).getSubject().get(idx2).setScore(score);
				System.out.println("��ϿϷ�!");
			} else {
				System.out.println("���������ʴ� ������Դϴ�.");
			}
		} else {
			System.out.println("���������ʴ� �л����Դϴ�.");
		}
	}

}
