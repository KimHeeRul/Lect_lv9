package lv10zobieProject;

public class Zombie extends Unit {

	public Zombie(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stat() {
		System.out.printf("[�̸�] : %s [ü��] :%d\n", super.getName(), super.getHp());
		System.out.printf("[���ݷ�] : %d [����] :%d [��ġ] :%d  \n", super.getAtt(), super.getDef(), super.getPos());
	}
//	public void attk(Unit unit) {
//		int dam = (this.getAtt() - unit.getDef()) * (ran.nextInt(150) + 50) / 100;
//		System.out.println(getName() + "�� ����!");
//		System.out.println(dam + "�� �����");
//		unit.setHp(unit.getHp() - dam);
//		if (unit.getHp() > 0) {
//			System.out.println(unit.getName() + "�� ���� ü��:" + unit.getHp());
//		} else {
//			System.out.println(unit.getName() + "óġ");
//		}
//
//	}

}
