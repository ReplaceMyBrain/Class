package com.javalec.PanelUserProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageAptitudeResult.MAR_Bean;

public class UP_DbAction {
	
	
	//-----------------
	//Field 
	//-----------------
		private final String url_mysql = data_Enviroment_define.url_mysql;
		private final String id_mysql = data_Enviroment_define.id_mysql;
		private final String pw_mysql = data_Enviroment_define.pw_mysql;
		int userNum;
		String userName;
		String userId;
		String userPw;
		String userEmail;
		String userResultM;
		String userResultA;
		String userState;
		

	//-----------------
	//Construction
	//-----------------
		public UP_DbAction(int userNum) {
			super();
			this.userNum = userNum;
		}		
				

		
	//-----------------
	//Method
	//-----------------	
		

		//유저 프로필 Dowoo 2021.04.29
		public UP_Bean UP_Show() {
			
			UP_Bean bean =null;			
			
	      String A = "select userName,userId,userEmail,userResultM,userResultA from user "; 
	      String B = "where userNUM = ";
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(A + B + userNum);

	          while(rs.next()){
	          	String wkUserName=(rs.getString(1));
	          	String wkUserId=(rs.getString(2));
	          	String wkUserEmail=(rs.getString(3));
	          	String wkUserResultM=(rs.getString(4));
	          	String wkUserResultA=(rs.getString(5));
	          	
	          	
	          	
	          	bean = new UP_Bean(wkUserName,wkUserId,wkUserEmail,wkUserResultM,wkUserResultA);

	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
	
	//탈퇴 Dowoo 2021.04.29
		public boolean UP_WithdrawalAction() {
			PreparedStatement ps = null;
			String A = "update user set userState = '탈퇴'";
	        String B = "where userNum = ? ";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		
					ps = conn_mysql.prepareStatement(A+B); 
			         ps.setInt(1, userNum);
			         ps.executeUpdate();
		
				return true;
			}catch (Exception e){
				e.printStackTrace();
		        return false;
			}
			
		}

	
	
	
}//////////////
