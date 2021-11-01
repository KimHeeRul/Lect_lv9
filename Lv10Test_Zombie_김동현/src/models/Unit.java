package models;

import java.util.Random;

public abstract class Unit {
	protected int hp;
	protected int pos;
	protected String name;
	protected int att;
	protected int def;
	Random ran = new Random();

	public Unit(String name, int hp, int pos, int att, int def) {
		this.name = name;
		this.hp = hp;
		this.pos = pos;
		this.att = att;
		this.def = def;
	}

	public abstract void stat();

	public boolean attack(Unit unit) {
		System.out.println(this.name + "의 공격!");
		int dam = (this.att - unit.def) * (ran.nextInt(150) + 50) / 100;
		if (dam <= 0) {
			dam = 1;
		}
		System.out.println(dam + "의 대미지");
		unit.setHp(unit.getHp() - dam);
		if (unit.getHp() <= 0) {
			unit.setHp(0);
		}
		System.out.println(unit.getName() + "의 남은 체력:" + unit.getHp());
		if (unit.getHp() > 0) {
			return true;
		} else {
			System.out.println(unit.getName() + "처치");
			return false;
		}
	};

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
