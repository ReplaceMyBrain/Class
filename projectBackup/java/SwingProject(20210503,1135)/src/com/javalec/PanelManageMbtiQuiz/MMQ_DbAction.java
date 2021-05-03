// 수훈 CRUD 추가 및 화면 불러오기추가 
package com.javalec.PanelManageMbtiQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageMbtiQuiz.MMQ_Bean;

public class MMQ_DbAction {

   //Field
   
   private final String url_mysql = data_Enviroment_define.url_mysql;
   private final String id_mysql = data_Enviroment_define.id_mysql;
   private final String pw_mysql = data_Enviroment_define.pw_mysql;
   
   //데이터베이스의 mbtiqiesiton 테이블 컬럼명가져오기
   int mqNum;
   String mqQuestion;
   String mqType;
   String mqAnswer1;
   String mqAnswer2;
   String mqScore1;
   String mqScore2;
   String selection;
   String selectType;
   
   // Constructor
   public MMQ_DbAction() {
      // TODO Auto-generated constructor stub
   }


   public MMQ_DbAction(String mqQuestion, String mqType, String mqAnswer1, String mqAnswer2, String mqScore1,
         String mqScore2) {
      super();
      this.mqQuestion = mqQuestion;
      this.mqType = mqType;
      this.mqAnswer1 = mqAnswer1;
      this.mqAnswer2 = mqAnswer2;
      this.mqScore1 = mqScore1;
      this.mqScore2 = mqScore2;
   }


   public MMQ_DbAction(String mqQuestion, String mqType, String mqAnswer1, String mqAnswer2, String mqScore1,
         String mqScore2, int mqNum) {
      super();
      this.mqQuestion = mqQuestion;
      this.mqType = mqType;
      this.mqAnswer1 = mqAnswer1;
      this.mqAnswer2 = mqAnswer2;
      this.mqScore1 = mqScore1;
      this.mqScore2 = mqScore2;
      this.mqNum= mqNum;
   }
   
   
   
   public MMQ_DbAction(int mqNum) {
      super();
      this.mqNum = mqNum;
   }


   //Method
   
   public MMQ_DbAction(String selectType) {
	super();
	this.selectType = selectType;
}


//전체검색 >> 테이블 채우기
   public ArrayList<MMQ_Bean> selectList(){
	   
	   ArrayList<MMQ_Bean> beanList = new ArrayList<MMQ_Bean>();
	   String WhereDefault = "select mqNum, mqType, mqQuestion, mqAnswer1, mqAnswer2 from mbtiquestion ";
	   
	   try{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		   Statement stmt_mysql = conn_mysql.createStatement();
		   ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
		   
		   while(rs.next()){
			   int mqNum =rs.getInt(1);
			   String mqType = rs.getString(2);
			   String mqQuestion =rs.getString(3);
			   String mqAnswer1 =rs.getString(4);
			   String mqAnswer2 =rs.getString(5);
			   
			   MMQ_Bean bean = new MMQ_Bean(mqNum, mqType, mqQuestion, mqAnswer1, mqAnswer2);
			   beanList.add(bean);
		   }
		   conn_mysql.close();
	   }
	   catch (Exception e){
		   e.printStackTrace();
	   }
	   return beanList;
	   
   }
   
   //조건 검색
   public ArrayList<MMQ_Bean> ConditionQueryAction() {
	   
	   
	   ArrayList<MMQ_Bean> beanList = new ArrayList<MMQ_Bean>();
	   String WhereDefault = "select mqNum, mqType, mqQuestion, mqAnswer1, mqAnswer2 from mbtiquestion where mqType = '" + selectType + "'";
	   try{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		   Statement stmt_mysql = conn_mysql.createStatement();
		   
		   ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
		   
		   while(rs.next()){
			   int mqNum = rs.getInt(1);
			   String mqType = rs.getString(2);
			   String mqQuestion = rs.getString(3);
			   String mqAnswer1 = rs.getString(4);
			   String mqAnswer2 = rs.getString(5);

			   MMQ_Bean bean = new MMQ_Bean(mqNum, mqType, mqQuestion, mqAnswer1, mqAnswer2);
			   beanList.add(bean);
		   }
		   conn_mysql.close();
	   }
	   catch (Exception e){
		   e.printStackTrace();
	   }
	   return beanList;
	   
   }
   
   //테이블 클릭시 보여주기
   public MMQ_Bean TableClick() {
         
      MMQ_Bean bean =null;
         
         //tfSelection.setText(stSequence);
         String WhereDefault = "select mqNum, mqQuestion, mqType, mqAnswer1, mqAnswer2, mqScore1, mqScore2 from mbtiquestion "; 
         String WhereDefault2 = "where mqNum = " ;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
             Statement stmt_mysql = conn_mysql.createStatement();

             ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 + mqNum);

             while(rs.next()){
                int mqNum=(rs.getInt(1));
                String mqQuestion=(rs.getString(2));
                String mqType=(rs.getString(3));
                String mqAnswer1=(rs.getString(4));
                String mqAnswer2=(rs.getString(5));
                String mqScore1=(rs.getString(6));
                String mqScore2=(rs.getString(7));
                
                bean = new MMQ_Bean(mqNum, mqQuestion, mqType, mqAnswer1, mqAnswer2, mqScore1, mqScore2);

             }
             conn_mysql.close();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return bean;
      }

   
   //입력 메소드
   public boolean insertAction(){
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
         Statement stmt_mysql = conn_mysql.createStatement();

            String A = "insert into mbtiquestion (mqQuestion, mqType, mqAnswer1, mqAnswer2, mqScore1 , mqScore2";
            String B = ") values (?,?,?,?,?,?)";

            ps = conn_mysql.prepareStatement(A+B);
            ps.setString(1, mqQuestion.trim());
            ps.setString(2, mqType.trim());
            ps.setString(3, mqAnswer1.trim());
            ps.setString(4, mqAnswer2.trim());
            ps.setString(5, mqScore1.trim());
            ps.setString(6, mqScore2.trim());
            ps.executeUpdate();

            conn_mysql.close();
            return true;
        } catch (Exception e){               
            e.printStackTrace();
            return false;
        
        }
   }
   
   
   //수정메소드
   public boolean UpdateAction() {
      
      PreparedStatement ps = null;
      try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
             @SuppressWarnings("unused")
            Statement stmt_mysql = conn_mysql.createStatement();
             
             String query = "update mbtiquestion set mqQuestion = ? , mqType = ? , mqAnswer1 = ? , mqAnswer2 = ? , mqScore1 = ? , mqScore2 = ? ";
             String query2 = "where mqNum = ? "; 
             //   변수  7개
             ps = conn_mysql.prepareStatement(query + query2);
             ps.setString(1, mqQuestion.trim());
             ps.setString(2, mqType.trim());
             ps.setString(3, mqAnswer1.trim());
             ps.setString(4, mqAnswer2.trim());
             ps.setString(5, mqScore1.trim());
             ps.setString(6, mqScore2.trim());
             ps.setInt(7, mqNum);
             ps.executeUpdate();
             
             conn_mysql.close();
             return true;
      }
      
      catch (Exception e){
             e.printStackTrace();
             return false;
         }            
   }
   
   //삭제
      public boolean DeleteAction() {
         PreparedStatement ps = null;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
             @SuppressWarnings("unused")
            Statement stmt_mysql = conn_mysql.createStatement();

             String A = "delete from mbtiquestion where mqNum = ? ";
            
             ps = conn_mysql.prepareStatement(A); 
             ps.setInt(1,mqNum);
             ps.executeUpdate();

             conn_mysql.close();
             
             return true;
         } catch (Exception e){
             e.printStackTrace();
             return false;
         }
            
                             
      }
   
   

   
  
   
   
}//===================