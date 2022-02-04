package models;

public class Account {
	private String accNum;
	private int Money;
	private	boolean rep;
	
	public Account() {
	
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public boolean isRep() {
		return rep;
	}
	public void setRep(boolean rep) {
		this.rep = rep;
	}
	
}

