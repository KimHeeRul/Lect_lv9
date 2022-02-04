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
	public void init(int max,int pw) {//���� ������ ü�°� �Ŀ� ���� init
		this.curhp=max;
		this.maxhp=max;
		this.power=pw;
	}
	public void printData() {//����
		System.out.println("["+this.name+"] ["+this.curhp+"/"+this.maxhp+"] ["+this.power+"]" );
	}
	
	public void attack(Unit target) {//���ְ� �Ѱ��ָ�
		target.curhp-=this.power;
		System.out.println("["+name+"]�� ["+target.name+"] ����"+this.power+"�� �������� �����ϴ�.");
		if (target.curhp<=0) {
			System.out.println("["+target.name+"] �� óġ�߽��ϴ�.");
			target.curhp=0;
		}
	}
	
}
