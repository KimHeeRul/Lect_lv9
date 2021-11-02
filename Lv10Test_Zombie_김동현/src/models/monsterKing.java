package models;

public class monsterKing extends Unit {
	private int shield;

	public monsterKing(String name, int hp, int pos, int att, int def, int shield) {
		super(name, hp, pos, att, def);
		this.shield = shield;
	}

	@Override
	public void stat() {
		System.out.printf("[�̸�] : %s [ü��] : %d\n", name, hp);
		System.out.printf("[���ݷ�] : %d [����] : %d [��ġ] : %d [�ǵ�] : %d \n", att, def, pos, shield);
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public boolean attack(Unit unit) {// ����ŷ
		System.out.println(this.name + "�� ����!");
		int dam = (this.att - unit.def) * (ran.nextInt(150) + 50) / 100;
		if (dam <= 0) {
			dam = 1;
		}
		System.out.println(dam + "�� �����");
		unit.setHp(unit.getHp() - dam);
		if (unit.getHp() <= 0) {
			unit.setHp(0);
		}
		System.out.println(unit.getName() + "�� ���� ü��:" + unit.getHp());
		if (unit.getHp() > 0) {
			return true;
		} else {
			System.out.println(unit.getName() + "óġ");
			System.out.println("�¸��ߴ�.");
			return false;
		}
	}
}
