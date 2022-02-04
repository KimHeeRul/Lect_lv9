package models;

import java.util.ArrayList;

public class User {
	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	private ArrayList<Account> acc = new ArrayList<>();

	private User() {
	}

	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccCnt() {
		return accCnt;
	}

	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}

	public ArrayList<Account> getAcc() {
		return acc;
	}

	public void setAcc(ArrayList<Account> acc) {
		this.acc = acc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

}
