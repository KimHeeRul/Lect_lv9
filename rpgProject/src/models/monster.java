package models;

import java.util.Random;

public class monster {
	private String name = "1";
	private int hp;
	private int atk;

	Random rand = new Random();

	public monster() {
		this.hp = rand.nextInt(50) + 20;
		this.atk = rand.nextInt(10) + 4;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	
	
}
