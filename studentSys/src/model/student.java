package model;

import java.util.ArrayList;

import control.registration;

public class student extends registration{
	private String name;
	ArrayList<subject> subject = new ArrayList<subject>();

	
	
	
	public student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<subject> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<subject> subject) {
		this.subject = subject;
	}
	
	public void add(String sub) {//�����߰�
		subject.add(new subject(sub));
	}

}
