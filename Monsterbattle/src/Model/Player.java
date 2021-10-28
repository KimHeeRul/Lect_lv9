package Model;

import java.util.Random;

import Control.GameManager;

public class Player extends Unit {
	public Player(String name, int max, int power) {
		super(name, max, power);
	}

	public int skill(int size) {
		System.out.println("[1].에너지 슬래시 [2].힐");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {// 슬래시
			return 1;
		} else {// 힐
			return 2;
			
		}

	}
	public void skillAttack(Unit target) {
		target.curhp-=this.power*2;
		System.out.println("["+name+"]이 ["+target.name+"] 에게"+this.power*2+"의 강력한 데미지를 입힙니다.");
		if (target.curhp<=0) {
			System.out.println("["+target.name+"] 를 처치했습니다.");
			target.curhp=0;
		}
	}
	

}
