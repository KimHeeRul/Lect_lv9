package models;

public class Hero extends Unit {
	int cnt = 3;

	public Hero(String name, int hp, int pos, int att, int def) {
		super(name, hp, pos, att, def);
	}

	@Override
	public void stat() {
		System.out.printf("[�̸�] : %s [ü��] : %d\n", name, hp);
		System.out.printf("[���ݷ�] : %d [����] : %d [��ġ] : %d\n", att, def, pos);
	}

	@Override
	public boolean attack(Unit unit) {
		boolean result = true;
		if (unit.getName().equals("����ŷ")) {// ����ŷ�̶��
			monsterKing king = (monsterKing) unit;
			if (king.getShield() > 0) {
				System.out.println("����� ����!");
				int dam = (this.att - king.def) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(dam + "�� �����");
				int sh = king.getShield();
				king.setShield(sh - dam);
				if (king.getShield() <= 0) {// �ǵ��ı�
					king.setShield(0);
					System.out.println("���带 �μ̽��ϴ�.");
					int addAtt = sh - dam;
					king.setHp(king.getHp() + addAtt);
				}
				System.out.println(king.getName() + "�� ���� ü��: " + king.getHp() + " (���� : " + king.getShield() + ")");

			} else {
				result=super.attack(unit);
			}
		} else {
			result=super.attack(unit);
		}
		return result;
	}



	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void drink() {// ȸ������
		if (cnt>0) {
		System.out.println("ȸ������ ���ʴϴ�.");
		System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
		this.setHp(this.getHp() + 100);
		System.out.println("����� ���� ü��:" + this.getHp());
		this.cnt -= 1;
		}else {
			System.out.println("������ ��������");
		}
	}

}
