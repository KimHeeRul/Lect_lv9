package models;

public class monsterKing extends Unit {
	private int shield;

	public monsterKing(String name, int hp, int pos, int att, int def, int shield) {
		super(name, hp, pos, att, def);
		this.shield = shield;
	}

	@Override
	public void stat() {
		System.out.printf("[이름] : %s [체력] : %d\n", name, hp);
		System.out.printf("[공격력] : %d [방어력] : %d [위치] : %d [실드] : %d \n", att, def, pos, shield);
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public boolean attack(Unit unit) {// 좀비킹
		boolean result = true;
		if (ran.nextInt(100) > 74) {// 필살기확률
			int dam = (this.getAtt() - unit.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam < 0) {// 0이하일때만 1로 고정
				dam = 1;
			}
			dam *= 2;
			System.out.println(getName() + "의 필살기!");
			System.out.println(dam + "의 대미지");
			unit.setHp(unit.getHp() - dam);
			System.out.println(unit.getName() + "의 남은체력: " + unit.getHp());
		} else {
			result = super.attack(unit);
//			System.out.println(this.name + "의 공격!");
//			int dam = (this.att - unit.def) * (ran.nextInt(150) + 50) / 100;
//			if (dam <= 0) {
//				dam = 1;
//			}
//			System.out.println(dam + "의 대미지");
//			unit.setHp(unit.getHp() - dam);
//			if (unit.getHp() <= 0) {
//				unit.setHp(0);
//			}
//			System.out.println(unit.getName() + "의 남은 체력:" + unit.getHp());
//			if (unit.getHp() > 0) {
//				return true;
//			} else {
//				System.out.println(unit.getName() + "처치");
//				System.out.println("승리했다.");
//				return false;
//			}
		}
		return result;
	}
}
