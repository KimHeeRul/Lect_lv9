package Stage;

import java.util.Random;
import java.util.Vector;

import Control.UnitManager;
import Model.Player;
import Model.Unit;

public class StageBattle extends Stage {
	UnitManager unitmanager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random rand = new Random();
	int monDead = 0;
	int playerDead = 0;

	@Override
	public boolean update() {
		boolean run = true;
		int playerIndex = 0;
		int monsterIndex = 0;
		boolean turn = true;
		while (run) {
			if (turn) {// ���� �÷��̾��� ���̶��

			} else {// ���� ������ ���̶��

			}
		}
		return false;
	}

	@Override
	public void init() {
		unitmanager.monList.clear();// ����Ʈ ����
		unitmanager.monster_rand_set(4);// ���� 4���� ����

		playerList = unitmanager.playerList;
		playerDead = playerList.size();
		monDead = monList.size();
		System.out.println("======BATTLE=======");
	}

}
