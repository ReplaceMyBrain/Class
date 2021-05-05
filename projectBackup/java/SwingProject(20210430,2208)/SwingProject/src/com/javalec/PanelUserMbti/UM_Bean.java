package com.javalec.PanelUserMbti;

public class UM_Bean {

	//Field
	
	int mqNum;
	int countNum;

	String mqQuiestion;
	String mqType;
	String mqAnswer1;
	String mqAnswer2;
	String mqScroe1;
	String m1Score2;
	
	//Constructor
	public UM_Bean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

	public UM_Bean(String mqQuiestion, String mqAnswer1, String mqAnswer2) {
		super();
		this.mqQuiestion = mqQuiestion;
		this.mqAnswer1 = mqAnswer1;
		this.mqAnswer2 = mqAnswer2;
	}

	
	public UM_Bean(int countNum) {
		super();
		this.countNum = countNum;
	}
	
	//Method


	public int getMqNum() {
		return mqNum;
	}

	public void setMqNum(int mqNum) {
		this.mqNum = mqNum;
	}

	public String getMqQuiestion() {
		return mqQuiestion;
	}

	public void setMqQuiestion(String mqQuiestion) {
		this.mqQuiestion = mqQuiestion;
	}

	public String getMqType() {
		return mqType;
	}

	public void setMqType(String mqType) {
		this.mqType = mqType;
	}

	public String getMqAnswer1() {
		return mqAnswer1;
	}

	public void setMqAnswer1(String mqAnswer1) {
		this.mqAnswer1 = mqAnswer1;
	}

	public String getMqAnswer2() {
		return mqAnswer2;
	}

	public void setMqAnswer2(String mqAnswer2) {
		this.mqAnswer2 = mqAnswer2;
	}

	public String getMqScroe1() {
		return mqScroe1;
	}

	public void setMqScroe1(String mqScroe1) {
		this.mqScroe1 = mqScroe1;
	}

	public String getM1Score2() {
		return m1Score2;
	}

	public void setM1Score2(String m1Score2) {
		this.m1Score2 = m1Score2;
	}
	
	
	
	
	
	
	

}
