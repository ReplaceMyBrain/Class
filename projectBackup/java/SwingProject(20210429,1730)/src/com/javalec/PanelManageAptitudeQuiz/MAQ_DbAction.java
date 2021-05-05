package com.javalec.PanelManageAptitudeQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;

public class MAQ_DbAction {
	
	//----------------------------------------------------------
	//Field	
	//----------------------------------------------------------
	private final String url_mysql = data_Enviroment_define.url_mysql;
	private final String id_mysql = data_Enviroment_define.id_mysql;
	private final String pw_mysql = data_Enviroment_define.pw_mysql;
	
	int aqNum;
	String aqQuestion;
	String aqAnswer1;
	String aqAnswer2;
	String aqScore1;
	String aqScore2;
	
	
	
	
	//----------------------------------------------------------
	//Construction
	//----------------------------------------------------------
	public MAQ_DbAction() {
		// TODO Auto-generated constructor stub
	}


	public MAQ_DbAction(String aqQuestion, String aqAnswer1, String aqAnswer2, String aqScore1, String aqScore2) {
		super();
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		this.aqScore1 = aqScore1;
		this.aqScore2 = aqScore2;
	}


	public MAQ_DbAction(String aqQuestion, String aqAnswer1, String aqAnswer2, String aqScore1, String aqScore2,
			int aqNum) {
		super();
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		this.aqScore1 = aqScore1;
		this.aqScore2 = aqScore2;
		this.aqNum = aqNum;
	}


	public MAQ_DbAction(int aqNum) {
		super();
		this.aqNum = aqNum;
	}
	
	
	
	//----------------------------------------------------------
	//Method
	//----------------------------------------------------------
	//전체 검색(table)
	 public ArrayList<MAQ_Bean> selectList(){
		 ArrayList<MAQ_Bean> beanList = new ArrayList<MAQ_Bean>();
		 String WhereDefault = "select aqNum, aqQuestion, aqAnswer1, aqAnswer2 from swing_project_team3.aptitudequestion ";
	      
			try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	          while(rs.next()){
	             int aqNum = rs.getInt(1);
	             String aqQuestion = rs.getString(2);
	             String aqAnswer1 = rs.getString(3);
	             String aqAnswer2 = rs.getString(4);
	             
	             MAQ_Bean bean = new MAQ_Bean(aqNum, aqQuestion, aqAnswer1, aqAnswer2);
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
	 public MAQ_Bean TableClick() { 
	
		 MAQ_Bean maq_bean = null;
	
		String WhereDefault = "select aqNum, aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2 from swing_project_team3.aptitudequestion "; 
		String WhereDefault2 = "where seqno = " ;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 + aqNum); //aptitudequestion에서 aqNum을 받아옴
	
	          while(rs.next()){
	          	int aqNum = rs.getInt(1);
	          	String aqQuestion = rs.getString(2);
	          	String aqAnswer1 = rs.getString(3);
	          	String aqAnswer2 = rs.getString(4);
	          	String aqScore1 = rs.getString(5);
	          	String aqScore2 = rs.getString(6);
	          	
	          	maq_bean = new MAQ_Bean(aqNum, aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2);
	          	
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return maq_bean; // return 잊지말기
	}
	 
	 
	
	//생성 버튼 동작 확인+query
	//SungAh 2021.04.28.
	public boolean insertAction_boolean() { // 반환값 boolean 확인, 맞으면 true/틀리면 false
		PreparedStatement ps = null;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();						
			String query = "insert into swing_project_team3.aptitudequestion (aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2) values (?,?,?,?,?)";
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, aqQuestion.trim());
			ps.setString(2, aqAnswer1.trim());
			ps.setString(3, aqAnswer2.trim());
			ps.setString(4, aqScore1.trim());
			ps.setString(5, aqScore2.trim());
			ps.executeUpdate();					
			
			conn_mysql.close(); //DB 연결 끊기
			return true;
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기
			return false;
		}
	}
	
	// 수정 버튼 동작 확인+query
	//SungAh 2021.04.28
	public boolean MAQ_editAction_boolean() {
	      PreparedStatement ps = null;
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	          @SuppressWarnings("unused")
	          Statement stmt_mysql = conn_mysql.createStatement();
	          String A = "update swing_project_team3.aptitudequestion set aqQuestion = ?, aqAnswer1 = ?, aqAnswer2 = ?, aqScore1 = ?, aqScore2 = ? ";
	          String B = " where aqNum = ? ";

	          ps = conn_mysql.prepareStatement(A+B);
			  ps.setString(1, this.aqQuestion);
			  ps.setString(2, this.aqAnswer1);
			  ps.setString(3, this.aqAnswer2);
			  ps.setString(4, this.aqScore1);
			  ps.setString(5, this.aqScore2);
			  ps.setInt(6,  aqNum);
			  ps.executeUpdate(); // update문 실행

			  conn_mysql.close();
			  return true;
			          
		} catch (Exception e){
			e.printStackTrace();
			return false;
	    }
	}
	
	
	// 삭제 액션
	//SungAh 2021.04.28
	public boolean MAQ_deleteAction_boolean() {
      PreparedStatement ps = null;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
          @SuppressWarnings("unused")
          Statement stmt_mysql = conn_mysql.createStatement();

          String A = "delete from swing_project_team3.aptitudequestion where aqNum = ? " ;
		  ps = conn_mysql.prepareStatement(A);
		       
		  ps.setInt(1, aqNum);
		  ps.executeUpdate();

		  conn_mysql.close();
		  return true;
      	} catch (Exception e){
		 e.printStackTrace();
		 return false;
	 	}
	}
		
}//------------------------------------------------------
