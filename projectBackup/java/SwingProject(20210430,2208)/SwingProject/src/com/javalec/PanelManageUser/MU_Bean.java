package com.javalec.PanelManageUser;

public class MU_Bean {

	//-----------------
	//Field 
	//-----------------
	int userNum;
	String userName;
	String userID;
	String userPW;
	String userEmail;
	String userResultM;
	String userResultA;
	String userState;
	
	
	//-----------------
	//Construction
	//-----------------
	public MU_Bean(int userNum, String userState, String userName, String userID, String userEmail) {
		super();
		this.userNum = userNum;
		this.userState = userState;
		this.userName = userName;
		this.userID = userID;
		this.userEmail = userEmail;
	}
		
	public MU_Bean(int userNum, String userState, String userName, String userID, String userEmail, String userResultM,
			String userResultA) {
		super();
		this.userNum = userNum;
		this.userState = userState;
		this.userName = userName;
		this.userID = userID;
		this.userEmail = userEmail;
		this.userResultM = userResultM;
		this.userResultA = userResultA;
	}



	//-----------------
	//Method
	//-----------------
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
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
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
	
}
