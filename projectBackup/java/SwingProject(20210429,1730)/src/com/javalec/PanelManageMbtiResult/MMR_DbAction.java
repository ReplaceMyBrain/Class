package com.javalec.PanelManageMbtiResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageMbtiResult.MMR_Bean;

public class MMR_DbAction {

	//-----------------
	//Field 
	//-----------------
	private final String url_mysql = data_Enviroment_define.url_mysql;
	private final String id_mysql = data_Enviroment_define.id_mysql;
	private final String pw_mysql = data_Enviroment_define.pw_mysql;
	
	int mrNum;
	String mrName;
	String mrExplain;
	
	
	//-----------------
	//Construction
	//-----------------
	
	
	//	 삭제 생성자
	//	 Dowoo 2021.04.28
	 
 	//검색 생성자  Dowoo 2021.04.29
	public MMR_DbAction() {

	}
	
	//입력 생성자 Dowoo 2021.04.29
	public MMR_DbAction(String mrName, String mrExplain) {
		super();
		this.mrName = mrName;
		this.mrExplain = mrExplain;
	}
	//수정 생성자 Dowoo 2021.04.29
	public MMR_DbAction(int mrNum, String mrName, String mrExplain) {
		super();
		this.mrNum = mrNum;
		this.mrName = mrName;
		this.mrExplain = mrExplain;
	}
	//	 삭제 생성자  Dowoo 2021.04.28
	public MMR_DbAction(int mrNum) {
		super();
		this.mrNum = mrNum;
	}

	
	//-----------------
	//Method
	//-----------------

	//-----------------
	//Method
	//-----------------
	
	//전체검색  Dowoo 2021.04.29
	
	public ArrayList<MMR_Bean> MMR_selectList(){
		
		ArrayList<MMR_Bean> beanList = new ArrayList<MMR_Bean>();
		String A = "select mrNum, mrName, mrExplain from mbtiresult" ;
	   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql =conn_mysql.createStatement();
	        ResultSet rs = stmt_mysql.executeQuery(A);
	        
	        while(rs.next()){
	        	int wkMrNum =rs.getInt(1);
	        	String wkMrName =rs.getString(2);
	        	String wkMrExplain =rs.getString(3);
	        	
	        	MMR_Bean bean = new MMR_Bean(wkMrNum, wkMrName, wkMrExplain);
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
		public MMR_Bean MMR_TableClick() {
			
			MMR_Bean bean =null;
			
	      //tfSelection.setText(stSequence);
	      String A = "select mrNum, mrName, mrExplain from mbtiresult "; 
	      String B = "where mrNUM = ";
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(A + B + mrNum);

	          while(rs.next()){
	          	int wkMrNum=(rs.getInt(1));
	          	String wkMrName=(rs.getString(2));
	          	String wkMrExplain=(rs.getString(3));
	          	
	          	bean = new MMR_Bean(wkMrNum,wkMrName,wkMrExplain);

	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
	      return bean;
		}
		
	//입력 Dowoo 2021.04.29
	public boolean  MMR_insertAction(){
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "insert into mbtiresult (mrName, mrExplain";
			String B = ") values (?,?)";

			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, mrName.trim());
			ps.setString(2, mrExplain.trim());
			ps.executeUpdate();

			conn_mysql.close();
			return true;
	        } catch (Exception e){               
	            e.printStackTrace();
	            return false;
	        
	        }
		}	
		
	//수정 Dowoo 2021.04.29
	public boolean MMR_UpdateAction() {
		PreparedStatement ps = null;
		      
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update mbtiresult set mrName = ?, mrExplain = ?";
			String B = "where mrNum = ? ";
		          
		     ps = conn_mysql.prepareStatement(A+B);
		     ps.setString(1, mrName.trim());
		     ps.setString(2, mrExplain.trim());
		     ps.setInt(3, mrNum);
		     ps.executeUpdate();

		     conn_mysql.close();
		      return true;   
		      
		      } catch (Exception e){
		          e.printStackTrace();
		      return false;
		      } 
		
	}
	
	
	
	//삭제 Dowoo 2021.04.28
	public boolean MMR_DeleteAction() {
		PreparedStatement ps = null;
		String A =  "delete from mbtiresult where mrNum = ? ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	
				ps = conn_mysql.prepareStatement(A); 
				ps.setInt(1,mrNum);
				ps.executeUpdate();

				conn_mysql.close();
	
			return true;
		}catch (Exception e){
			e.printStackTrace();
	        return false;
		}
		
	}

	
}////////////////////////////
