package lv10zobieProject;

public class ZombieKing extends Unit implements att {
	private int shield;

	public ZombieKing(String name, int hp, int att, int def, int pos, int shield) {
		super(name, hp, att, def, pos);
		this.shield = shield;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attk(Unit unit) {
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
			super.attk(unit);
		}

	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public void stat() {
		System.out.printf("[이름] : %s [체력] :%d\n", super.getName(), super.getHp());
		System.out.printf("[공격력] : %d [방어력] :%d [위치] :%d [쉴드] : %d \n", super.getAtt(), super.getDef(), super.getPos(),
				this.shield);

	}

}
