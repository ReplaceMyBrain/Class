package com.javalec.PanelUserStatistic;

public class US_Bean { 	//Dowoo 2021.04.30 완료
	
	//-----------------
	//Field 
	//-----------------
	String userName;
	String userResultM;
	String userResultA;
	String count;
	String userResultMA; // TOP3보여주는 메소드작업시 오버로드 불가하여  통합하여 하나의 생성자만 사용할 예정.

	

	
	
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

	
	public US_Bean(String userResultMA, String count) {
		super();
		this.userResultM = userResultMA;
		this.count = count;
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
	
	public String getUserResultMA() {
		return userResultMA;
	}


	public void setUserResultMA(String userResultMA) {
		this.userResultMA = userResultMA;
	}

	
	
		

}
