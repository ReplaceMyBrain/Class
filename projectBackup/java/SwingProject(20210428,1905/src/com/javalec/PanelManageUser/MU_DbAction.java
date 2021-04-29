package com.javalec.PanelManageUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javalec.Datadefine.data_Enviroment_define;

public class MU_DbAction {

	
	//-----------------
	//Field 
	//-----------------
	private final String url_mysql = data_Enviroment_define.url_mysql;
	private final String id_mysql = data_Enviroment_define.id_mysql;
	private final String pw_mysql = data_Enviroment_define.pw_mysql;
	
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
	
	
	//	 탈퇴 생성자
	//	 Dowoo 2021.04.28
	 
	public MU_DbAction(int userNum) {
		super();
		this.userNum = userNum;
	}
	
	
	
	//-----------------
	//Method
	//-----------------
	
	
	//탈퇴 Dowoo 2021.04.28
	public boolean WithdrawalAction() {
		PreparedStatement ps = null;
		String A = "update user set userState = ? ";
        String B = " where userNum = ? ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	
				ps = conn_mysql.prepareStatement(A+B); 
				 ps.setString(1, userState.trim());
		         ps.setInt(2, userNum);
		         ps.executeUpdate();
	
			return true;
		}catch (Exception e){
			e.printStackTrace();
	        return false;
		}
		
	}
	

	
}////////////////////////////
