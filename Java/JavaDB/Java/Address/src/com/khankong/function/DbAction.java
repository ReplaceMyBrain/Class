package com.khankong.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.khankong.function.ShareVar;

public class DbAction {
	//-----------------
	//Field  //SharVar에서 가져오기!
	//-----------------
	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	//데이터베이스에 있는 컬럼과 똑같이 만들어야 안헷갈린다.
	int seqno;
	String name;
	String telno;
	String address;
	String email;
	String relation;
	String selection;
	String ConditionQueryColumn;

	//-----------------
	//Construction
	//-----------------
	public DbAction() {
		// TODO Auto-generated constructor stub
	}
	

	public DbAction(String name, String telno, String address, String email, String relation) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}
	
	//오버로드
	public DbAction(int seqno) {
		super();
		this.seqno = seqno;
	}
	
	public DbAction(String name, String telno, String address, String email, String relation, int seqno) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.seqno =seqno;
	}
	
	public DbAction(String selection, String ConditionQueryColumn) {
		super();
		this.selection = selection;
		this.ConditionQueryColumn = ConditionQueryColumn;
	}
	
	


	//-----------------
	//Method
	//-----------------
	
	//입력
	public boolean insertAction(){
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

            String A = "insert into userinfo (name, telno, address, email, relation";
            String B = ") values (?,?,?,?,?)";

            ps = conn_mysql.prepareStatement(A+B);
            ps.setString(1, name.trim());
            ps.setString(2, telno.trim());
            ps.setString(3, address.trim());
            ps.setString(4, email.trim());
            ps.setString(5, relation.trim());
            ps.executeUpdate();

            conn_mysql.close();
            return true;
        } catch (Exception e){               
            e.printStackTrace();
            return false;
        
        }
	}

	//전체검색
	public ArrayList<Bean> selectList(){
     
			ArrayList<Bean> beanList = new ArrayList<Bean>();
			String WhereDefault = "select seqno, name, telno, relation from userinfo ";
		   
			try{
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		        Statement stmt_mysql = conn_mysql.createStatement();
		        ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
		        
		        while(rs.next()){
		        	int wkSeq =rs.getInt(1);
		        	String wkName =rs.getString(2);
		        	String wkTelno =rs.getString(3);
		        	String wkRelation =rs.getString(4);
		        	
		        	Bean bean = new Bean(wkSeq, wkName, wkTelno, wkRelation);
		        	beanList.add(bean);
		        }
		          conn_mysql.close();
		    }
		    catch (Exception e){
		          e.printStackTrace();
		    }
		    return beanList;
			
	}
	
	//검색
	
	public ArrayList<Bean> ConditionQueryAction() {


		ArrayList<Bean> beanList = new ArrayList<Bean>();
		String WhereDefault = "select seqno, name, telno, relation from userinfo where " + ConditionQueryColumn;
		String WhereDefault2 = " like '%" + selection.trim() + "%'";
     

		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          Statement stmt_mysql = conn_mysql.createStatement();
		
		          ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
		
		          while(rs.next()){
		        	  int wkSeq =rs.getInt(1);
			        	String wkName =rs.getString(2);
			        	String wkTelno =rs.getString(3);
			        	String wkRelation =rs.getString(4);
			        	
			        	Bean bean = new Bean(wkSeq, wkName, wkTelno, wkRelation);
			        	beanList.add(bean);
		          }
		          conn_mysql.close();
		      }
		      catch (Exception e){
		          e.printStackTrace();
		      }
		      return beanList;
			
	}
	
	
	
	
	//테이블 클릭시 보여주기.
	public Bean TableClick() {
		
		Bean bean =null;
		
      //tfSelection.setText(stSequence);
      String WhereDefault = "select seqno, name, telno, address, email, relation from userinfo "; 
      String WhereDefault2 = "where seqno = " ;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
          Statement stmt_mysql = conn_mysql.createStatement();

          ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 + seqno);

          while(rs.next()){
          	int wkSeq=(rs.getInt(1));
          	String wkName=(rs.getString(2));
          	String wkTelno=(rs.getString(3));
          	String wkAddress=(rs.getString(4));
          	String wkEmail=(rs.getString(5));
          	String wkRelation=(rs.getString(6));
          	
          	bean = new Bean(wkSeq,wkName,wkTelno,wkAddress,wkEmail,wkRelation);

          }
          conn_mysql.close();
      }
      catch (Exception e){
          e.printStackTrace();
      }
      return bean;
	}
	
	
	//삭제
	public boolean DeleteAction() {
      PreparedStatement ps = null;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
          @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

          String A = "delete from userinfo where seqno = ? ";
         
          ps = conn_mysql.prepareStatement(A); 
          ps.setInt(1,seqno);
          ps.executeUpdate();

          conn_mysql.close();
          
          return true;
      } catch (Exception e){
          e.printStackTrace();
          return false;
      }
      	
              				
	}
	
	
	public boolean UpdateAction() {
      PreparedStatement ps = null;
      
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
          @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

          String A = "update userinfo set name = ?, telno = ?, address = ?, email = ?, relation = ? ";
          String B = " where seqno = ? ";
          
          ps = conn_mysql.prepareStatement(A+B);
          ps.setString(1, name.trim());
          ps.setString(2, telno.trim());
          ps.setString(3, address.trim());
          ps.setString(4, email.trim());
          ps.setString(5, relation.trim());
          ps.setInt(6, seqno);
          ps.executeUpdate();

          conn_mysql.close();
          return true;
          
      } catch (Exception e){
          e.printStackTrace();
          return false;
      }            
	}
	
	
	
	
	
}///////////