package Stage;

import Control.GameManager;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====TEXT RPG =======");
		System.out.println("������ �Է��ϼ���.");
		String input = GameManager.scan.next();
		if (input.equals("����")) {
			GameManager.nextStage = "LOBBY";
		}
		return false;
	}

	@Override
	public void init() {

	}

}
