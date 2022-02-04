package lv10zobieProject;

public class Zombie extends Unit {

	public Zombie(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stat() {
		System.out.printf("[이름] : %s [체력] :%d\n", super.getName(), super.getHp());
		System.out.printf("[공격력] : %d [방어력] :%d [위치] :%d  \n", super.getAtt(), super.getDef(), super.getPos());
	}
//	public void attk(Unit unit) {
//		int dam = (this.getAtt() - unit.getDef()) * (ran.nextInt(150) + 50) / 100;
//		System.out.println(getName() + "의 공격!");
//		System.out.println(dam + "의 대미지");
//		unit.setHp(unit.getHp() - dam);
//		if (unit.getHp() > 0) {
//			System.out.println(unit.getName() + "의 남은 체력:" + unit.getHp());
//		} else {
//			System.out.println(unit.getName() + "처치");
//		}
//
//	}

}
