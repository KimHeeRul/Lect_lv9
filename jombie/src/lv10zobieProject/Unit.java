package lv10zobieProject;

import java.util.Random;

public class Unit {
	Random ran = new Random();
	private int hp;
	private int att;
	private int def;
	private int pos;

	public Unit(int hp, int att, int def, int pos) {
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;

	}

}
