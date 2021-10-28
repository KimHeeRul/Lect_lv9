package Control;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Stage.Stage;
import Stage.StageBattle;
import Stage.StageLobby;
import Stage.StageTitle;

public class GameManager {
	Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	public static String curStage = "";
	Map<String, Stage> stageList = new HashMap<>();

	public GameManager() {// ������
		stageList.put("TITLE", new StageTitle());// �ؽ��ʾȿ� put
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		nextStage = "TITLE";
	}

	public boolean changeStage() {
		System.out.println("curStage:"+curStage);
		System.out.println("nextStage:"+nextStage);
		if (curStage.equals(nextStage)) {
			return false;//����
		}
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false) {
				break;
			}
		}
		if (nextStage.equals("")) {
			return false;//����
		}else 
			return true;//����
	}
}
