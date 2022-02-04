package Control;

import java.util.Random;
import java.util.Vector;

import Model.Player;
import Model.Unit;

public class UnitManager {

	public Vector<Player> playerList = new Vector<>();
	public Vector<Unit> monList = new Vector<>();
	public String path = "Model.";
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random rand = new Random();

	public UnitManager() {
		playerList.add(new Player("����", 1000, 45));
		playerList.add(new Player("������", 800, 60));
		playerList.add(new Player("����", 500, 70));
		
	}
	public void monster_rand_set(int size) {
		for (int i = 0; i < size; i++) {
			int num = rand.nextInt(mons.length);// 3
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;// ������ ���͸� Unitȭ
				int hp = rand.nextInt(100) + 100;
				int pow = rand.nextInt(10) + 10;
				temp.init(hp, pow);// ������ ü��,�Ŀ��� �ֱ�
				monList.add(temp);// �̸�,ü��,�Ŀ��� ��� ������ temp������ ����Ʈ�� �߰�
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ���� �Ѹ��� ����
		}
	}

}
