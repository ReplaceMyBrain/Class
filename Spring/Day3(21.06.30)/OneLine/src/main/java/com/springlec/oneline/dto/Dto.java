package com.springlec.oneline.dto;

import java.sql.Timestamp;

public class Dto {
	
	int no;
	String name;
	String title;
	Timestamp date;
	
	
	
	public Dto() {
		super();
	}


	public Dto(int no, String name, String title, Timestamp date) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.date = date;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
	
	
	

}
