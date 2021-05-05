package com.javalec.PanelUserStatistic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelUserProfile.UP_Bean;

public class US_DbAction {
	
	//Dowoo 2021.04.30 완료
	
	
	//-----------------
	//Field 
	//-----------------
		private final String url_mysql = data_Enviroment_define.url_mysql;
		private final String id_mysql = data_Enviroment_define.id_mysql;
		private final String pw_mysql = data_Enviroment_define.pw_mysql;
		
		int userNum;
		
		
	//-----------------
	//Construction
	//-----------------
		public US_DbAction() {	
	}


	public US_DbAction(int userNum) {
		super();
		this.userNum = userNum;
	}
		
		
	//-----------------
	//Method
	//-----------------	
	
	//유저정보
	public US_Bean US_Infor() {
		
		US_Bean bean =null;
		
		String A ="select userName, userResultM, userResultA  from user ";
		String B ="where userNum = ";
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(A + B + userNum);

	          while(rs.next()){
	        	  
	        	String wkUserName=(rs.getString(1));
	          	String wkUserResultM=(rs.getString(2));
	          	String wkUserResultA=(rs.getString(3));
	          	
	          	
	          	bean = new US_Bean(wkUserName,wkUserResultM,wkUserResultA);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
	//전체 유저의 수
	public US_Bean US_FullCount() {
		
		US_Bean bean =null;
		
		String A ="select count(*) from user";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(A);

	          while(rs.next()){
	        	  
	        	String wkCount=(rs.getString(1));
	         

	          	bean = new US_Bean(wkCount);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
	//유저에 해당하는 MBTI의 명수
	public US_Bean US_MbtiCount() {
		
		US_Bean bean =null;
		
		String A ="select count(*) from user ";
		String B ="where userResultM =(select userResultM from user where userNum=";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(A + B + userNum + ")");

	          while(rs.next()){
	        	  
	        	String wkCount=(rs.getString(1));
	         

	          	bean = new US_Bean(wkCount);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}

	
	//유저에 해당하는 적성의 명수
	public US_Bean US_AptitudeCount() {
		
		US_Bean bean =null;
		
		String A ="select count(*) from user ";
		String B ="where userResultA =(select userResultA from user where userNum=";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(A + B + userNum + ")");

	          while(rs.next()){
	        	  
	        	String wkCount=(rs.getString(1));
	         

	          	bean = new US_Bean(wkCount);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
	
	public US_Bean US_Aptitude1Top() {
		
		US_Bean bean =null;
		
		String A ="select userResultM, count(*) from user group by userResultM order by count(*) DESC limit 1";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(A);

	          while(rs.next()){
	        	String wkUserResultM=(rs.getString(1));
	        	String wkCount=(rs.getString(2));
	      
	        	bean = new US_Bean(wkUserResultM,wkCount);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
			return bean;
		}
	public US_Bean US_Aptitude2Top() {
		
		US_Bean bean =null;
		
		String A ="select userResultA, count(*) from user group by userResultM order by count(*) DESC limit 1";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	          ResultSet rs = stmt_mysql.executeQuery(A);

	          while(rs.next()){
	        	String wkUserResultA=(rs.getString(1));
	        	String wkCount=(rs.getString(2));
	      
	        	bean = new US_Bean(wkUserResultA,wkCount);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
			return bean;
		}
	
	
	
}////////
