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
	public void init(int max,int pw) {//몬스터 생성후 체력과 파워 결정 init
		this.maxhp=max;
		this.power=pw;
	}
	void printData() {//정보
		System.out.println("["+this.name+"] ["+this.curhp+"/"+this.maxhp+"] ["+this.power+"]" );
	}
	
}
