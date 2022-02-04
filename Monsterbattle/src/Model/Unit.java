package Model;

public class Unit {
	public int curhp;
	public int maxhp;
	public int power;
	public String name;
	public Unit(String name,int max,int power) {
		this.name=name;
		this.maxhp=max;
		this.curhp=max;
		this.power=power;
	}
	public Unit() {
		
	}
	public void init(int max,int pw) {//몬스터 생성후 체력과 파워 결정 init
		this.curhp=max;
		this.maxhp=max;
		this.power=pw;
	}
	public void printData() {//정보
		System.out.println("["+this.name+"] ["+this.curhp+"/"+this.maxhp+"] ["+this.power+"]" );
	}
	
	public void attack(Unit target) {//유닛값 넘겨주면
		target.curhp-=this.power;
		System.out.println("["+name+"]이 ["+target.name+"] 에게"+this.power+"의 데미지를 입힙니다.");
		if (target.curhp<=0) {
			System.out.println("["+target.name+"] 를 처치했습니다.");
			target.curhp=0;
		}
	}
	
}
