package com.javalec.base2;

public class Student {

	//field
	String name;
	int score;
	
	
	//constructor
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	//method
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
}
