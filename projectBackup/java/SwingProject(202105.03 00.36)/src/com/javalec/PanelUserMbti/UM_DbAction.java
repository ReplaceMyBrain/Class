package com.javalec.PanelUserMbti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageMbtiQuiz.MMQ_Bean;

public class UM_DbAction {

	//Field
	
	 private final String url_mysql = data_Enviroment_define.url_mysql;
	 private final String id_mysql = data_Enviroment_define.id_mysql;
	 private final String pw_mysql = data_Enviroment_define.pw_mysql;
	 public static int mqNum ;
	   
	 String MBTI;
	 int Numchk;
	//Constructor
	public UM_DbAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UM_DbAction(int Numchk) {
		super();
		this.Numchk = Numchk;
	}
	
	public UM_DbAction(String MBTI) {
		super();
		this.MBTI=MBTI;
	}
	
//===============================
//	메소드정의
//===============================


	//Method
	public ArrayList<UM_Bean> UM_countMbtiNum() {	// 마지막문제 풀고 끝내기 2. ( 문제 총 갯수구하기)
			
		ArrayList<UM_Bean> beanList1 = new ArrayList<UM_Bean>();
		String countmqNum = "select count(mqNum) from mbtiquestion";
		
			try{
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				   Statement stmt_mysql = conn_mysql.createStatement();
				   
				   ResultSet rs = stmt_mysql.executeQuery(countmqNum);
				   
				   while(rs.next()) {
					  int countNum = rs.getInt(1);
					  UM_Bean bean = new UM_Bean(countNum);
					  beanList1.add(bean);
				   }
				   
				   conn_mysql.close();
			   }
			   catch (Exception e){
				   e.printStackTrace();
			   }
			 return beanList1;
		}

	// 문제 와 답안 채우기
	public ArrayList<UM_Bean> selectMbtiQuiz(){
		   
		   ArrayList<UM_Bean> beanList = new ArrayList<UM_Bean>();
		   String inputMbti = "select mqQuestion, mqAnswer1, mqAnswer2 from mbtiquestion "
				   				+ "where mqNum = " + Numchk;
		   
		   try{
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			   Statement stmt_mysql = conn_mysql.createStatement();
			   
			   ResultSet rs = stmt_mysql.executeQuery(inputMbti);
			   
			   while(rs.next()){
				   String mqQuestion =rs.getString(1);
				   String mqAnswer1 =rs.getString(2);
				   String mqAnswer2 =rs.getString(3);
				   
				   UM_Bean bean = new UM_Bean(mqQuestion, mqAnswer1, mqAnswer2);
				   beanList.add(bean);
			   }
			   UM_Bean bean = new UM_Bean("", "", "");
			   beanList.add(bean);
			   conn_mysql.close();
		   }
		   catch (Exception e){
			   e.printStackTrace();
		   }
		   return beanList;
	   }
	
	// 엠비티아이 스코어 불러오기
	public ArrayList<UM_Bean> selectTypeScore() {
		
		ArrayList<UM_Bean> beanList = new ArrayList<UM_Bean>();
		String eachType = "select mqType, mqScore1, mqScore2 from mbtiquestion where mqNum =" + Numchk;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(eachType);
			
			while(rs.next()) {
				String mqType = rs.getString(1);
				int mqScore1 = rs.getInt(2);
				int mqScore2 = rs.getInt(3);
				
			
			UM_Bean bean = new UM_Bean(mqType, mqScore1, mqScore2);
			beanList.add(bean);
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return beanList;
	}
	
	//엠비티아이 설명 불러오기
	
public ArrayList<UM_Bean> selectExplain() {
		
		ArrayList<UM_Bean> beanList = new ArrayList<UM_Bean>();
		String explain = "select mrExplain from mbtiresult where mrType = '" + MBTI + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(explain);
			
			while(rs.next()) {
				String mrExplain = rs.getString(1);
			
			UM_Bean bean = new UM_Bean(mrExplain);
			beanList.add(bean);
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return beanList;
	}

// MBTI 이름 불러오기
	public ArrayList<UM_Bean> selectName() {
		
		ArrayList<UM_Bean> beanList = new ArrayList<UM_Bean>();
		String name = "select mrName from mbtiresult where mrType = '" + MBTI + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(name);
			
			while(rs.next()) {
				String mrName = rs.getString(1);
			
			UM_Bean bean = new UM_Bean(mrName);
			beanList.add(bean);
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return beanList;
	}
	
	
	
}//======================================
