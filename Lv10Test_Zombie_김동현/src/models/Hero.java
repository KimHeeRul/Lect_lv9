package models;

public class Hero extends Unit {
	int cnt = 3;

	public Hero(String name, int hp, int pos, int att, int def) {
		super(name, hp, pos, att, def);
	}

	@Override
	public void stat() {
		System.out.printf("[이름] : %s [체력] : %d\n", name, hp);
		System.out.printf("[공격력] : %d [방어력] : %d [위치] : %d\n", att, def, pos);
	}

	@Override
	public boolean attack(Unit unit) {
		boolean result = true;
		if (unit.getName().equals("좀비킹")) {// 좀비킹이라면
			monsterKing king = (monsterKing) unit;
			if (king.getShield() > 0) {
				System.out.println("용사의 공격!");
				int dam = (this.att - king.def) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(dam + "의 대미지");
				int sh = king.getShield();
				king.setShield(sh - dam);
				if (king.getShield() <= 0) {// 실드파괴
					king.setShield(0);
					System.out.println("쉴드를 부셨습니다.");
					int addAtt = sh - dam;
					king.setHp(king.getHp() + addAtt);
				}
				System.out.println(king.getName() + "의 남은 체력: " + king.getHp() + " (쉴드 : " + king.getShield() + ")");

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

	public void drink() {// 회복물약
		if (cnt>0) {
		System.out.println("회복약을 마십니다.");
		System.out.println("체력이 100회복 되었습니다.");
		this.setHp(this.getHp() + 100);
		System.out.println("용사의 남은 체력:" + this.getHp());
		this.cnt -= 1;
		}else {
			System.out.println("물약이 떨어졌다");
		}
	}

}
