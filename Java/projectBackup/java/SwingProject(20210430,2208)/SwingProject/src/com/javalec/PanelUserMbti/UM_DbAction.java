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
	   
	 int Numchk;
	public static int mqNum ;
	//Constructor
	public UM_DbAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UM_DbAction(int Numchk) {
		super();
		this.Numchk = Numchk;
	}
	




	//Method
	public ArrayList<UM_Bean> UM_countMbtiNum() {
			
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
	
	
	
	
	
	
	
	
}//======================================
