package com.javalec.PanelManageAptitudeResult;

public class MAR_Bean {

	
	//-----------------
	//Field 
	//-----------------
	int arNum;
	String arName;
	String arExplain;

	
	//-----------------
	//Construction
	//-----------------
	
	//검색생성자 Dowoo 2021.04.29
	public MAR_Bean(int arNum, String arName, String arExplain) {
		super();
		this.arNum = arNum;
		this.arName = arName;
		this.arExplain = arExplain;
	}
	
	//-----------------
	//Method
	//-----------------
	public int getArNum() {
		return arNum;
	}

	public void setArNum(int arNum) {
		this.arNum = arNum;
	}
	public String getArName() {
		return arName;
	}
	public void setArName(String arName) {
		this.arName = arName;
	}
	public String getArExplain() {
		return arExplain;
	}
	public void setArExplain(String arExplain) {
		this.arExplain = arExplain;
	}
	
}
