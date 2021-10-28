package Stage;

import java.util.Random;
import java.util.Vector;

import javax.management.monitor.Monitor;

import Control.GameManager;
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
				printChar();
				if (playerIndex < playerList.size()) {// 턴 순서
					playerAttack(playerIndex);
					playerIndex++;
				} else {
					turn = false;// 턴체인지
					playerIndex = 0;
				}
			} else {// 만약 몬스터의 턴이라면
				if (monsterIndex < monList.size()) {// 턴 순서
					monsterAttack(monsterIndex);
					monsterIndex++;
				} else {
					turn = true;// 턴 체인지
					monsterIndex = 0;
				}

			}
			liveCheck();
			if (monDead <= 0 || playerDead <= 0) {// 몬스터나 플레이어가 0명이하로 살아남았을때
				break;// 로비로탈출
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	void liveCheck() {// 죽은 인원체크
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).curhp <= 0) {
				num++;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).curhp <= 0) {
				num++;
			}
		}
		monDead = monList.size() - num;
	}

	private void printChar() {// 몬스터와 플레이어 정보 출력
		System.out.println("------BATTLE-------");
		System.out.println("======PLAYER=======");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======MONSTER=======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	public void playerAttack(int index) {// 플레이어 공격턴
		System.out.println("===========메뉴선택==========");
		System.out.print("[" + playerList.get(index).name + "] ");
		System.out.println("[1.어택] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int ran = rand.nextInt(monList.size());
				if (monList.get(ran).curhp > 0) {// 랜덤선택된 몬스터의 체력이 0이상일경우 (dead체크)
					playerList.get(index).attack(monList.get(ran));// 플레이어의 어택에 몬스터 객체를 던져주기
					// 몬스터 객체 넘기기
					break;
				}
			}
		} else {
			System.out.println("스킬 미구현");
			int skill = playerList.get(index).skill(monList.size());
			if (skill == 1) {
				int ran = rand.nextInt(monList.size());
				if (monList.get(ran).curhp > 0) {// 랜덤선택된 몬스터의 체력이 0이상일경우 (dead체크)
					playerList.get(index).skillAttack(monList.get(ran));// 플레이어의 어택에 몬스터 객체를 던져주기
				}
			} else if (skill == 2) {
				playerList.get(index).curhp+=200;
				if (playerList.get(index).curhp>playerList.get(index).maxhp) {
					playerList.get(index).curhp=playerList.get(index).maxhp;
				}
			}
		}
	}

	public void monsterAttack(int index) {// 몬스터 공격턴
		if (monList.get(index).curhp > 0) {// 살아있는 몬스터라면
			while (true) {
				int ran = rand.nextInt(playerList.size());
				if (playerList.get(ran).curhp > 0) {
					monList.get(index).attack(playerList.get(ran));
					break;
				}
			}
		} else {
			return;// 메소드 탈출
		}

	}

	@Override
	public void init() {
		unitmanager.monList.clear();// 리스트 비우기
		unitmanager.monster_rand_set(4);// 몬스터 4마리 세팅

		playerList = unitmanager.playerList;
		monList = null;
		monList = unitmanager.monList;
		playerDead = playerList.size();
		monDead = monList.size();

	}

}
