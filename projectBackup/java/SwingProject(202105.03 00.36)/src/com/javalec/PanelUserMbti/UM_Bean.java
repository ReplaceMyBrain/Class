package com.javalec.PanelUserMbti;

public class UM_Bean {

	//Field
	
	int mqNum;
	int countNum;
	
	String mrExName;
	String mqQuiestion;
	String mqType;
	String mqAnswer1;
	String mqAnswer2;
	int mqScore1;
	int mqScore2;
	
	//Constructor
	public UM_Bean() {
		// TODO Auto-generated constructor stub
	}
	

	public UM_Bean(String mqType, int mqScore1, int mqScore2) {
		super();
		this.mqType = mqType;
		this.mqScore1 = mqScore1;
		this.mqScore2 = mqScore2;
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
	
	public UM_Bean(String mrExName) {
		super();
		this.mrExName = mrExName;

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

	public int getMqScroe1() {
		return mqScore1;
	}

	public void setMqScroe1(String mqScroe1) {
		this.mqScore1 = mqScore1;
	}

	public int getM1Score2() {
		return mqScore2;
	}

	public void setM1Score2(String m1Score2) {
		this.mqScore2 = mqScore2;
	}
	
	public int getCountNum() {
		return countNum;
	}
	
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}


	public String getMrExName() {
		return mrExName;
	}


	public void setMrExName(String mrExName) {
		this.mrExName = mrExName;
	}

	
	
}///////////////////////
