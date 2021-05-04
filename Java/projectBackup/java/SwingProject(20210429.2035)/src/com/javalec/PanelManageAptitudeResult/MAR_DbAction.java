package com.javalec.PanelManageAptitudeResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;

public class MAR_DbAction {
	
	//-----------------
	//Field 
	//-----------------
	private final String url_mysql = data_Enviroment_define.url_mysql;
	private final String id_mysql = data_Enviroment_define.id_mysql;
	private final String pw_mysql = data_Enviroment_define.pw_mysql;
	
	int arNum;
	String arName;
	String arExplain;

	
	
	//-----------------
	//Construction
	//-----------------
	
	

	//검색 생성자  Dowoo 2021.04.29
	public MAR_DbAction() {
		
	}
	
	//입력 생성자 Dowoo 2021.04.29
	MAR_DbAction(String arName, String arExplain) {
		super();
		this.arName = arName;
		this.arExplain = arExplain;
	}
	//수정 생성자 Dowoo 2021.04.29
	public MAR_DbAction(int arNum, String arName, String arExplain) {
		super();
		this.arNum = arNum;
		this.arName = arName;
		this.arExplain = arExplain;
	}
	//	 삭제 생성자  Dowoo 2021.04.28
	public MAR_DbAction(int arNum) {
		super();
		this.arNum = arNum;
	}

	
	
	//-----------------
	//Method
	//-----------------
	
	//전체검색  Dowoo 2021.04.29
	
	public ArrayList<MAR_Bean> MAR_selectList(){
		
		ArrayList<MAR_Bean> beanList = new ArrayList<MAR_Bean>();
		String A = "select arNum, arName, arExplain from aptituderesult" ;
	   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql =conn_mysql.createStatement();
	        ResultSet rs = stmt_mysql.executeQuery(A);
	        
	        while(rs.next()){
	        	int wkarNum =rs.getInt(1);
	        	String wkarName =rs.getString(2);
	        	String wkarExplain =rs.getString(3);
	        	
	        	MAR_Bean bean = new MAR_Bean(wkarNum, wkarName, wkarExplain);
	        	beanList.add(bean);
	        }
	          conn_mysql.close();
	        
	    }
	    catch (Exception e){
	          e.printStackTrace();
	    }
	    return beanList;
		
	}
	

		//테이블 클릭시 보여주기. Dowoo 2021.04.29
		public MAR_Bean MAR_TableClick() {
			
			MAR_Bean bean =null;
			
	      String A = "select arNum, arName, arExplain from aptituderesult "; 
	      String B = "where arNUM = ";
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(A + B + arNum);

	          while(rs.next()){
	          	int wkArNum=(rs.getInt(1));
	          	String wkArName=(rs.getString(2));
	          	String wkArExplain=(rs.getString(3));
	          	
	          	bean = new MAR_Bean(wkArNum,wkArName,wkArExplain);

	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
		
	//입력 Dowoo 2021.04.29
	public boolean  MAR_insertAction(){
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "insert into aptituderesult (arName, arExplain";
			String B = ") values (?,?)";

			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, arName.trim());
			ps.setString(2, arExplain.trim());
			ps.executeUpdate();

			conn_mysql.close();
			return true;
	        } catch (Exception e){               
	            e.printStackTrace();
	            return false;
	        
	        }
		}	
		
	
	
	//수정 Dowoo 2021.04.29
	public boolean MAR_UpdateAction() {
		PreparedStatement ps = null;
		      
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update aptituderesult set arName = ?, arExplain = ?";
			String B = "where arNum = ? ";
		          
		     ps = conn_mysql.prepareStatement(A+B);
		     ps.setString(1, arName.trim());
		     ps.setString(2, arExplain.trim());
		     ps.setInt(3, arNum);
		     ps.executeUpdate();

		     conn_mysql.close();
		      return true;   
		      
		      } catch (Exception e){
		          e.printStackTrace();
		      return false;
		      } 
		
	}
	
	
	//삭제 Dowoo 2021.04.28
	public boolean MAR_DeleteAction() {
		PreparedStatement ps = null;
		String A =  "delete from aptituderesult where arNum = ? ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	
				ps = conn_mysql.prepareStatement(A); 
				ps.setInt(1,arNum);
				ps.executeUpdate();

				conn_mysql.close();
	
			return true;
		}catch (Exception e){
			e.printStackTrace();
	        return false;
		}
		
	}
	
	
	
	
	
	
	
}////////////////////////////
