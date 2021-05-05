package com.javalec.PanelUserStatistic;

public class US_Bean { 	//Dowoo 2021.04.30 완료
	
	//-----------------
	//Field 
	//-----------------
	String userName;
	String userResultM;
	String userResultA;
	String count;
	int mrNum;
	String mrType;
	String mrName;
	String mrExplain;

	

	
	
	//-----------------
	//Construction
	//-----------------
	


	public US_Bean() {
	}


	public US_Bean( String userName, String userResultM, String userResultA) {
		super();
		this.userName = userName;
		this.userResultM = userResultM;
		this.userResultA = userResultA;
		
	}
	
	public US_Bean(String count) {
		this.count=count;
	}

	
	public US_Bean(String userResultM, String count) {
		super();
		this.userResultM = userResultM;
		this.count = count;
	}

	public US_Bean(int mrNum, String mrType, String mrName, String mrExplain) {
		super();
		this.mrNum = mrNum;
		this.mrType = mrType;
		this.mrName = mrName;
		this.mrExplain = mrExplain;
	}


	//-----------------
	//Method
	//-----------------	
	public String getUserResultM() {
		return userResultM;
	}

	public void setUserResultM(String userResultM) {
		this.userResultM = userResultM;
	}



	public String getUserResultA() {
		return userResultA;
	}



	public void setUserResultA(String userResultA) {
		this.userResultA = userResultA;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}
	public int getMrNum() {
		return mrNum;
	}


	public void setMrNum(int mrNum) {
		this.mrNum = mrNum;
	}


	public String getMrType() {
		return mrType;
	}


	public void setMrType(String mrType) {
		this.mrType = mrType;
	}


	public String getMrName() {
		return mrName;
	}


	public void setMrName(String mrName) {
		this.mrName = mrName;
	}


	public String getMrExplain() {
		return mrExplain;
	}


	public void setMrExplain(String mrExplain) {
		this.mrExplain = mrExplain;
	}



		

}
