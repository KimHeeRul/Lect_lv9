package models;

public class Unit {
	String name;
	int level;
	int hp;
	int maxHp;
	int att;
	int def;
	int exp;
	boolean party;
	Item weapon;
	Item armor;
	Item ring;

	public Unit(String name,int level,int hp,int att,int def,int exp) {//캐릭터 생성
		this.name =name;
		this.level =level;
		this.hp=hp;
		this.att=att;
		this.def=def;
		this.exp=exp;
	}
	
	
}
