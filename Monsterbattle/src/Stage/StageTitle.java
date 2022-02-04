package Stage;

import Control.GameManager;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====TEXT RPG =======");
		System.out.println("시작을 입력하세요.");
		String input = GameManager.scan.next();
		if (input.equals("시작")) {
			GameManager.nextStage = "LOBBY";
		}
		return false;
	}

	@Override
	public void init() {

	}

}
