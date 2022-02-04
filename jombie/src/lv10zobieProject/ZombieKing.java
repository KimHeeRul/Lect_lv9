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
		if (ran.nextInt(100) > 74) {// �ʻ��Ȯ��
			int dam = (this.getAtt() - unit.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam < 0) {// 0�����϶��� 1�� ����
				dam = 1;
			}
			dam *= 2;
			System.out.println(getName() + "�� �ʻ��!");
			System.out.println(dam + "�� �����");
			unit.setHp(unit.getHp() - dam);
			System.out.println(unit.getName() + "�� ����ü��: " + unit.getHp());

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
		System.out.printf("[�̸�] : %s [ü��] :%d\n", super.getName(), super.getHp());
		System.out.printf("[���ݷ�] : %d [����] :%d [��ġ] :%d [����] : %d \n", super.getAtt(), super.getDef(), super.getPos(),
				this.shield);

	}

}
