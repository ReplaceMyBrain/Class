package com.javalec.PanelManageUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	public MU_DbAction() {
		// TODO Auto-generated constructor stub
	}
	
	public MU_DbAction(String userState, String userName, String userID, String userEmail, int userNum) {
		super();		
		this.userState = userState;
		this.userName = userName;
		this.userID = userID;
		this.userEmail = userEmail;
		this.userNum = userNum;
	}
	
	public MU_DbAction(int userNum, String userState, String userName, String userID, String userEmail,
			String userResultM, String userResultA) {
		super();
		this.userNum = userNum;
		this.userState = userState;
		this.userName = userName;
		this.userID = userID;
		this.userEmail = userEmail;
		this.userResultM = userResultM;
		this.userResultA = userResultA;
	}

	public MU_DbAction(String userName, String userID, String userEmail, int userNum) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userEmail = userEmail;
		this.userNum = userNum;
	}
	
	

	//	 탈퇴 생성자
	//	 Dowoo 2021.04.28
	 

	public MU_DbAction(int userNum) {
		super();
		this.userNum = userNum;
	}	
	
	public MU_DbAction(String userState, int userNum) {
		super();
		this.userState = userState;
		this.userNum = userNum;
	}

	//-----------------
	//Method
	//-----------------
	//전체 검색(table)
	//SungAh 2021.04.29
	 public ArrayList<MU_Bean> selectList(){
		 ArrayList<MU_Bean> beanList = new ArrayList<MU_Bean>();
		 String WhereDefault = "select userNum, userState, userName, userID, userEmail, userResultM, userResultA from swing_project_team3.user ";
	      
			try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	          while(rs.next()){
	        	  int userNum = rs.getInt(1);
	             String userState = rs.getString(2);
	             String userName = rs.getString(3);
	             String userID = rs.getString(4);
	             String userEmail = rs.getString(5);
	             String userResultM = rs.getString(6);
	             String userResultA = rs.getString(7);
	             
	             MU_Bean bean = new MU_Bean(userNum, userState, userName, userID, userEmail, userResultM, userResultA);
	             beanList.add(bean);
	             
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		return beanList; // return 잊지말기
			
		}
	 
	 // 테이블 내의 각 행을 클릭했을 때, DataField에 출력
	 //SungAh 2021.04.29
	 public MU_Bean TableClick() { 
	
		 MU_Bean mu_bean = null;
	
		String WhereDefault = "select userNum, userState, userName, userID, userEmail, userResultM, userResultA from user "; 
		String WhereDefault2 = "where userNum = " ;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 + userNum); //user에서 userNum을 받아옴
	
	          while(rs.next()){
	          	int userNum = rs.getInt(1);
	          	String userState = rs.getString(2);
	          	String userName = rs.getString(3);
	          	String userID = rs.getString(4);
	          	String userEmail = rs.getString(5);
	          	String userResultM = rs.getString(6);
	          	String userResultA = rs.getString(7);
	          	
	          	mu_bean = new MU_Bean(userNum, userState, userName, userID, userEmail, userResultM, userResultA);
	          	
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return mu_bean; // return 잊지말기
	}
	
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
	
	
	// 수정 버튼 동작 확인+query
	//SungAh 2021.04.29
	public boolean MU_editAction_boolean() {
	      PreparedStatement ps = null;
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	          @SuppressWarnings("unused")
	          Statement stmt_mysql = conn_mysql.createStatement();
	          String A = "update user set userName = ?, userId = ?, userEmail = ? ";
	          String B = " where userNum = ? ";
		          ps = conn_mysql.prepareStatement(A+B);
			  ps.setString(1, this.userName);
			  ps.setString(2, this.userID);
			  ps.setString(3, this.userEmail);
			  ps.setInt(4,  userNum);
			  ps.executeUpdate(); // update문 실행
			  conn_mysql.close();
			  return true;
			          
		} catch (Exception e){
			e.printStackTrace();
			return false;
	    }
	}

	
}////////////////////////////
