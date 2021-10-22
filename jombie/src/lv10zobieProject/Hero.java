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
			System.out.println("회복약을 마십니다.");
			System.out.println("체력이 100회복 되었습니다.");
			setHp(getHp() + 100);
			System.out.println("용사의남은체력:" + getHp());
			this.cnt--;
		} else {
			System.out.println("물약이 없습니다.");
		}
	}

	public void att(Unit enemy) {
		if (enemy.getName() == "좀비킹") {
			ZombieKing king = (ZombieKing) enemy;// 형변환
			if (king.getShield() > 0) {
				int dam = (this.getAtt()- king.getDef())*(ran.nextInt(150)+50)/100;
				if (dam<0) {
					dam=1;
				}
				System.out.println(getName()+"의 공격!");
				System.out.println(dam+"의 대미지!");
				king.setShield(king.getShield()-dam);
				if (king.getShield()<=0) {//쉴드 파괴
					System.out.println(king.getName()+"의 쉴드가 박살났다!");
					int d=king.getShield()-dam;//쉴드 파괴후 남은 대미지 추가
					king.setShield(0);
					king.setHp(king.getHp()-d);
				}
				System.out.println(king.getName()+"의 남은 체력: "+king.getHp()+" (쉴드 : "+king.getShield()+")");
			} else {
				super.att(enemy);
			}

		} else {
			super.att(enemy);
		}
	}

}
