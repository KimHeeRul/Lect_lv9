package models;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	Item weapon;
	Item armor;
	Item ring;
	private boolean life=true;

	public Unit(String name, int level, int Maxhp, int att, int def, int exp) {// 캐릭터 생성
		this.name = name;
		this.level = level;
		this.maxHp = Maxhp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public Unit(String name, int level,  int hp,int Maxhp, int att, int def, int exp, boolean party) {// 캐릭터 생성
		this.name = name;
		this.level = level;
		this.maxHp = Maxhp;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = party;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	// 게터 세터
	
	
	public String getName() {
		return name;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

}
