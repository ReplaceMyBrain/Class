package com.javalec.PanelUserAptitudeQuiz;

import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.Datadefine.data_Enviroment_define;

public class UAQ_DbAction {
	
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
	
	
	int countQuizNum = 0; // 문제번호 : 초기값 0번
	int countQuizMax = 0; // 문제 갯수
	int sumScore = 0; // score 합계
	int userNum = data_Enviroment_define.userNum; // 유저번호
	String userResultA = ""; //userResultA 값 초기화(천직 혹은 한번 더 의심하기가 들어감)
	
	//----------------------------------------------------------
	//Construction
	//----------------------------------------------------------
	
	public UAQ_DbAction() {
		// TODO Auto-generated constructor stub
	}


	public UAQ_DbAction(String aqQuestion, String aqAnswer1, String aqAnswer2, int aqNum) {
		super();
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		this.aqNum = aqNum;
	}


	public UAQ_DbAction(String aqQuestion, String aqAnswer1, String aqAnswer2, String aqScore1, String aqScore2,
			int aqNum) {
		super();
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		this.aqScore1 = aqScore1;
		this.aqScore2 = aqScore2;
		this.aqNum = aqNum;
	}


	public UAQ_DbAction(int aqNum) {
		super();
		this.aqNum = aqNum;
	}	
	
	
	
	//----------------------------------------------------------
	//Method
	//----------------------------------------------------------
	
	//문제&답 출력
	public UAQ_Bean UAQ_ShowQuiz() {			
		UAQ_Bean bean = null;
		String query = "select aqQuestion, aqAnswer1, aqAnswer2 from swing_project_team3.aptitudequestion where aqNum="+countQuizNum;
		// 열값을 차례로 불러오기 위함	
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
				String aqQuestion = rs.getString(1);
				String aqAnswer1 = rs.getString(2);
				String aqAnswer2 = rs.getString(3);
				
				
				bean = new UAQ_Bean(aqQuestion, aqAnswer1, aqAnswer2);
				}
					
		conn_mysql.close(); //DB 연결 끊기
		
				
		}catch(Exception e) {
//			countQuizNum+=10;
			e.printStackTrace();// 화면에 에러코드 보여주기			
		}
		return bean;
	}
	


	//문제 총 갯수 불러오기
	public void UAQ_CountQuiz() {
		PreparedStatement ps = null;
	    try{
	  	  Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	         @SuppressWarnings("unused")
	        Statement stmt_mysql = conn_mysql.createStatement();
	
	        String countQuizMaxQuery = "select max(aqNum) from aptitudequestion";		          
	      //arNum=1의 갯수를 불러옴
	        ResultSet rs = stmt_mysql.executeQuery(countQuizMaxQuery); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
	        
				while(rs.next()) {
					countQuizMax = Integer.parseInt(rs.getString(1));
					}
				
	       conn_mysql.close();
	    }
	    
	    catch (Exception e){
	           e.printStackTrace();
	       }            
		
	}
	
	
	

	//(총계점수)sumScore += 1번 버튼 점수 계산
	public void UAQ_SendScore1() {
		String query = "select aqScore1 from swing_project_team3.aptitudequestion where aqNum="+(countQuizNum-1);
		// 열값을 차례로 불러오기 위함	
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
				int aqScore1 = Integer.parseInt(rs.getString(1));
				
				sumScore += aqScore1; // 총계점수				
				}
					
		conn_mysql.close(); //DB 연결 끊기
				
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	}
	
	//(총계점수)sumScore += 2번 버튼 점수 계산
	public void UAQ_SendScore2() {
		String query = "select aqScore2 from swing_project_team3.aptitudequestion where aqNum="+(countQuizNum-1);
		// 열값을 차례로 불러오기 위함	
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
				int aqScore2 = Integer.parseInt(rs.getString(1));
				
				sumScore += aqScore2; // 총계점수
				}
					
		conn_mysql.close(); //DB 연결 끊기
				
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	}
	
	
	//arName1 값 불러오기(score>=7)
	public void UAQ_UpdateResultA_Good() {
			PreparedStatement ps = null;
		      try{
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		           @SuppressWarnings("unused")
		          Statement stmt_mysql = conn_mysql.createStatement();

		          String result1 = "select arName from swing_project_team3.aptituderesult where arNum=1";		          
		        //arNum=1의 arName값을 불러옴
		          ResultSet rs = stmt_mysql.executeQuery(result1); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
		          
					while(rs.next()) {
						String resultA = rs.getString(1);
						userResultA = resultA; // userResultA 값 설정
						}
					
		         conn_mysql.close();
		      }
		      
		      catch (Exception e){
		             e.printStackTrace();
		         }            
			
		
	}
	
	//arName2 값 불러오기(score<7)
	public void UAQ_UpdateResultA_Bad() {
		PreparedStatement ps = null;
	      try{
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	           @SuppressWarnings("unused")
	          Statement stmt_mysql = conn_mysql.createStatement();
	          
	          String result1 = "select arName from swing_project_team3.aptituderesult where arNum=2";	          
	          //arNum=2의 arName값을 불러옴
	          ResultSet rs = stmt_mysql.executeQuery(result1); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
	          
				while(rs.next()) {
					String resultA = rs.getString(1);
					userResultA = resultA; // userResultA 값 설정
					}
				
	         conn_mysql.close();
	      }
	      
	      catch (Exception e){
	             e.printStackTrace();
	         }            
		
	
}
	
	
	//userResultA DB 업데이트
	public void UAQ_UpdateResultA_SendDB() {
		PreparedStatement ps = null;
	      try{
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	           @SuppressWarnings("unused")
	          Statement stmt_mysql = conn_mysql.createStatement();
	          
	          String query = "update user set userResultA = ? ";
	          String query2 = "where userNum = " + userNum; 
	          
	          ps = conn_mysql.prepareStatement(query + query2);
	          ps.setString(1, userResultA.trim()); // 천직 혹은 한번 더 의심하기 업데이트
	        
	          ps.executeUpdate();
	          
	          
	         conn_mysql.close();
//	             return true;
	      }
	      
	      catch (Exception e){
	             e.printStackTrace();
//	             return false;
	         }            
		
	
}
	
	
	
	
}//--------------
