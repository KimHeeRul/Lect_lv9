package lv10zobieProject;

import java.util.Random;

interface king {
	
}

public class Unit {
	Random ran = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;// ��

	public Unit(String name, int hp, int att, int def, int pos) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}

	public void stat() {
		System.out.printf("[�̸�] : %s [ü��] :%d\n", this.name, this.hp);
		System.out.printf("[���ݷ�] : %d [����] :%d [��ġ] :%d\n", this.att, this.def, this.pos);

	}

	public void att(Unit unit) {
		int dam= (this.att-unit.def)*(ran.nextInt(150)+50)/100;
		System.out.println(this.name+"�� ����!");
		System.out.println(dam+"�� �����");
		unit.setHp(unit.getHp()-dam);
		if (unit.hp>0) {
			System.out.println(unit.name+"�� ���� ü��:"+unit.hp);
		}else {
			System.out.println(unit.name+"óġ");
		}
	}
	
	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getAtt() {
		return att;
	}

	public int getDef() {
		return def;
	}

	public int getPos() {
		return pos;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
