package Model;

import java.util.Random;

import Control.GameManager;

public class Player extends Unit {
	public Player(String name, int max, int power) {
		super(name, max, power);
	}

	public int skill(int size) {
		System.out.println("[1].������ ������ [2].��");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {// ������
			return 1;
		} else {// ��
			return 2;
			
		}

	}
	public void skillAttack(Unit target) {
		target.curhp-=this.power*2;
		System.out.println("["+name+"]�� ["+target.name+"] ����"+this.power*2+"�� ������ �������� �����ϴ�.");
		if (target.curhp<=0) {
			System.out.println("["+target.name+"] �� óġ�߽��ϴ�.");
			target.curhp=0;
		}
	}
	

}
