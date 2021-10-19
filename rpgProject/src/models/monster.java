package models;

import java.util.Random;

public class monster {
	private String name;
	private int hp;
	private int atk;

	Random rand = new Random();

	public monster() {
		this.hp = rand.nextInt(50) + 20;
		this.atk = rand.nextInt(30) + 10;
		this.name = name();
	}

	public String name() {
		String[] n1 = { "���� ", "�ξ� ", "���� ", "�� ", "��� ", "�ظ� ", "���ĸ� " };
		String[] n2 = { "�屺", "����", "���", "����", "����" };
		String name = n1[rand.nextInt(n1.length)];
		name += n2[rand.nextInt(n2.length)];
		return name;
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
