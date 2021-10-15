package models;

public class Item {
	public static final int Weapon = 1;// 장비 고유의 분류값
	public static final int Armor = 2;
	public 	static final int Ring = 3;
	int kind;// 아이템의 고유분류값 지정
	String name;
	int power;
	int price;

	public Item(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;

	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
