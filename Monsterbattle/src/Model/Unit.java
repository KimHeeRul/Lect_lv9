package Model;

public class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	public Unit(String name,int max,int power) {
		this.name=name;
		this.maxhp=max;
		this.power=power;
	}
	public void init(int max,int pw) {//���� ������ ü�°� �Ŀ� ���� init
		this.maxhp=max;
		this.power=pw;
	}
	void printData() {//����
		System.out.println("["+this.name+"] ["+this.curhp+"/"+this.maxhp+"] ["+this.power+"]" );
	}
	
}
