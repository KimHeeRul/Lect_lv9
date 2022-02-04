package models;

public class monster extends Unit{

	public monster(String name, int hp, int pos, int att, int def) {
		super(name, hp, pos, att, def);
	}

	@Override
	public void stat() {
		System.out.printf("[이름] : %s [체력] : %d\n",name,hp);
		System.out.printf("[공격력] : %d [방어력] : %d [위치] : %d\n",att,def,pos);
	}

	@Override
	public boolean attack(Unit unit) {
		System.out.println(this.name+"의 공격!");
		int dam = (this.att - unit.def) * (ran.nextInt(150) + 50) / 100;
		if (dam <= 0) {
			dam = 1;
		}
		System.out.println(dam + "의 대미지");
		unit.setHp(unit.getHp() - dam);
		if (unit.getHp()<0) {
			unit.setHp(0);
		}
		System.out.println(unit.getName() + "의 남은 체력:" + unit.getHp());
		if (unit.getHp() > 0) {
			return true;
		} else {
			System.out.println(unit.getName() + "처치");
			return false;
		}
	}
}
