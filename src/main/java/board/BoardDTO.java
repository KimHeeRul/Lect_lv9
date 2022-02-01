package board;

import java.sql.Timestamp;

public class BoardDTO {
private int code,view,like;
private String title,content,id,password;
private Timestamp date;


public BoardDTO(String title,String content,String id,String password) {
	this.title=title;
	this.content=content;
	this.id=id;
	this.password=password;
}
public BoardDTO(int code,String title,String content,String id,String password,int view,int like, Timestamp date) {
	this.code=code;
	this.title=title;
	this.content=content;
	this.id=id;
	this.password=password;
	this.view=view;
	this.like=like;
	this.date=date;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public int getView() {
	return view;
}
public void setView(int view) {
	this.view = view;
}
public int getLike() {
	return like;
}
public void setLike(int like) {
	this.like = like;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}

	

}
