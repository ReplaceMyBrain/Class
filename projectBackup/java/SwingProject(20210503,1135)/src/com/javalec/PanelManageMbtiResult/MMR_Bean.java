package com.javalec.PanelManageMbtiResult;

public class MMR_Bean {

	
	//-----------------
	//Field 
	//-----------------
	int mrNum;
	String mrType;
	String mrName;
	String mrExplain;
	
	
	
	
	//-----------------
	//Construction
	//-----------------
	public MMR_Bean(int mrNum, String mrType, String mrName, String mrExplain) {
		super();
		this.mrNum = mrNum;
		this.mrType = mrType;
		this.mrName = mrName;
		this.mrExplain = mrExplain;
	}
	
	//-----------------
	//Method
	//-----------------
	public int getMrNum() {
		return mrNum;
	}
	public void setMrNum(int mrNum) {
		this.mrNum = mrNum;
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

	public String getMrType() {
		return mrType;
	}

	public void setMrType(String mrType) {
		this.mrType = mrType;
	}
	
}
