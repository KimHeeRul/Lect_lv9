package control;

public class scoreAdd extends registration {
	public void score() {
		System.out.print("학생명 입력:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx != -1) {
			System.out.print("관리할 과목명");
			String sub = scan.next();
			int idx2 = subCheck(idx, sub);
			if (idx2 != -1) {
				System.out.print("추가할 성적:");
				int score = scan.nextInt();
				student.get(idx).getSubject().get(idx2).setScore(score);
				System.out.println("등록완료!");
			} else {
				System.out.println("존재하지않는 과목명입니다.");
			}
		} else {
			System.out.println("존재하지않는 학생명입니다.");
		}
	}

}
