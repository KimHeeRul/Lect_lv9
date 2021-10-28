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
		playerList.add(new Player("전사", 1000, 45));
		playerList.add(new Player("마법사", 800, 60));
		playerList.add(new Player("힐러", 500, 70));
		
	}
	public void monster_rand_set(int size) {
		for (int i = 0; i < size; i++) {
			int num = rand.nextInt(mons.length);// 3
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;// 결정된 몬스터를 Unit화
				int hp = rand.nextInt(100) + 100;
				int pow = rand.nextInt(10) + 10;
				temp.init(hp, pow);// 결정된 체력,파워를 넣기
				monList.add(temp);// 이름,체력,파워가 모두 정해진 temp유닛을 리스트에 추가
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 몬스터 한마리 생성
		}
	}

}
