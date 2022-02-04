import Control.GameManager;

public class Main {

	public static void main(String[] args) {
		GameManager gameManager=new GameManager();
		boolean exit=true;
		while (true) {
			exit=gameManager.changeStage();
			if (exit==false) {
				break;
			}
		}
		System.out.println("게임오버");
	}

}
