package lv10zobieProject;

public class Hero extends Unit {
	private int cnt = 3;

	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	}

	public int potion() {
		return this.cnt;
	}

	public void drink() {
		if (this.cnt > 0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
			setHp(getHp() + 100);
			System.out.println("����ǳ���ü��:" + getHp());
			this.cnt--;
		} else {
			System.out.println("������ �����ϴ�.");
		}
	}

	public void att(Unit enemy) {
		if (enemy.getName() == "����ŷ") {
			ZombieKing king = (ZombieKing) enemy;// ����ȯ
			if (king.getShield() > 0) {
				int dam = (this.getAtt()- king.getDef())*(ran.nextInt(150)+50)/100;
				if (dam<0) {
					dam=1;
				}
				System.out.println(getName()+"�� ����!");
				System.out.println(dam+"�� �����!");
				king.setShield(king.getShield()-dam);
				if (king.getShield()<=0) {//���� �ı�
					System.out.println(king.getName()+"�� ���尡 �ڻ쳵��!");
					int d=king.getShield()-dam;//���� �ı��� ���� ����� �߰�
					king.setShield(0);
					king.setHp(king.getHp()-d);
				}
				System.out.println(king.getName()+"�� ���� ü��: "+king.getHp()+" (���� : "+king.getShield()+")");
			} else {
				super.att(enemy);
			}

		} else {
			super.att(enemy);
		}
	}

}
