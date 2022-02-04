package user;

import java.sql.Timestamp;

public class UserDTO {

//Data Transfer Object =Bean =VO(read only)=Entity Object=POJO
	
//캡슐화 
private int code;
private String id,pw,name;
private Timestamp regDate;

public UserDTO(String id,String pw) {
	this.id=id;
	this.pw=pw;
}
public UserDTO(String id,String pw,String name) {
	this.id=id;
	this.pw=pw;
	this.name=name;
}
public UserDTO(String pw) { //정보수정
	this.pw=pw;
}

public UserDTO(String id,String pw,Timestamp regDate) {
	this.id=id;
	this.pw=pw;
	this.regDate=regDate;
}
public UserDTO(int code,String id,String pw,String name, Timestamp regDate) {
	this.code=code;
	this.id=id;
	this.pw=pw;
	this.name=name;
	this.regDate=regDate;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
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
public Timestamp getRegDate() {
	return regDate;
}
public void setRegDate(Timestamp regDate) {
	this.regDate = regDate;
}
@Override
	public String toString() {
	return String.format("%d) %s/%s (%s)", this.code,this.id,this.pw,this.regDate);
}
	
	
	
}
