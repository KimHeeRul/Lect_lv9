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
			if (turn) {// 만약 플레이어의 턴이라면

			} else {// 만약 몬스터의 턴이라면

			}
		}
		return false;
	}

	@Override
	public void init() {
		unitmanager.monList.clear();// 리스트 비우기
		unitmanager.monster_rand_set(4);// 몬스터 4마리 세팅

		playerList = unitmanager.playerList;
		playerDead = playerList.size();
		monDead = monList.size();
		System.out.println("======BATTLE=======");
	}

}
