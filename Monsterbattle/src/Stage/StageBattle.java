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
			if (turn) {// ���� �÷��̾��� ���̶��
				printChar();
				if (playerIndex < playerList.size()) {// �� ����
					playerAttack(playerIndex);
					playerIndex++;
				} else {
					turn = false;// ��ü����
					playerIndex = 0;
				}
			} else {// ���� ������ ���̶��
				if (monsterIndex < monList.size()) {// �� ����
					monsterAttack(monsterIndex);
					monsterIndex++;
				} else {
					turn = true;// �� ü����
					monsterIndex = 0;
				}

			}
			liveCheck();
			if (monDead <= 0 || playerDead <= 0) {// ���ͳ� �÷��̾ 0�����Ϸ� ��Ƴ�������
				break;// �κ��Ż��
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	void liveCheck() {// ���� �ο�üũ
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

	private void printChar() {// ���Ϳ� �÷��̾� ���� ���
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

	public void playerAttack(int index) {// �÷��̾� ������
		System.out.println("===========�޴�����==========");
		System.out.print("[" + playerList.get(index).name + "] ");
		System.out.println("[1.����] [2.��ų]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int ran = rand.nextInt(monList.size());
				if (monList.get(ran).curhp > 0) {// �������õ� ������ ü���� 0�̻��ϰ�� (deadüũ)
					playerList.get(index).attack(monList.get(ran));// �÷��̾��� ���ÿ� ���� ��ü�� �����ֱ�
					// ���� ��ü �ѱ��
					break;
				}
			}
		} else {
			System.out.println("��ų �̱���");
			int skill = playerList.get(index).skill(monList.size());
			if (skill == 1) {
				int ran = rand.nextInt(monList.size());
				if (monList.get(ran).curhp > 0) {// �������õ� ������ ü���� 0�̻��ϰ�� (deadüũ)
					playerList.get(index).skillAttack(monList.get(ran));// �÷��̾��� ���ÿ� ���� ��ü�� �����ֱ�
				}
			} else if (skill == 2) {
				playerList.get(index).curhp+=200;
				if (playerList.get(index).curhp>playerList.get(index).maxhp) {
					playerList.get(index).curhp=playerList.get(index).maxhp;
				}
			}
		}
	}

	public void monsterAttack(int index) {// ���� ������
		if (monList.get(index).curhp > 0) {// ����ִ� ���Ͷ��
			while (true) {
				int ran = rand.nextInt(playerList.size());
				if (playerList.get(ran).curhp > 0) {
					monList.get(index).attack(playerList.get(ran));
					break;
				}
			}
		} else {
			return;// �޼ҵ� Ż��
		}

	}

	@Override
	public void init() {
		unitmanager.monList.clear();// ����Ʈ ����
		unitmanager.monster_rand_set(4);// ���� 4���� ����

		playerList = unitmanager.playerList;
		monList = null;
		monList = unitmanager.monList;
		playerDead = playerList.size();
		monDead = monList.size();

	}

}
