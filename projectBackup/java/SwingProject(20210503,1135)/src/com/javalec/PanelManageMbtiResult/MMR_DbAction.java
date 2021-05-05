package com.javalec.PanelManageMbtiResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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
	String mrType;
	String mrName;
	String mrExplain;
	String conname;
	String condate;
	FileInputStream mrImage;
	
	
	
	//-----------------
	//Construction
	//-----------------
	
	
	//	 삭제 생성자
	//	 Dowoo 2021.04.28
	 
 	//검색 생성자  Dowoo 2021.04.29
	public MMR_DbAction() {

	}
	
	//입력 생성자 Dowoo 2021.04.29
	public MMR_DbAction(String mrType, String mrName, String mrExplain, FileInputStream mrImage) {
		super();
		this.mrType = mrType;
		this.mrName = mrName;
		this.mrExplain = mrExplain;
		this.mrImage=mrImage;
	}
	//수정 생성자 Dowoo 2021.04.29
	public MMR_DbAction(int mrNum, String mrType, String mrName, String mrExplain, FileInputStream mrImage) {
		super();
		this.mrNum = mrNum;
		this.mrType = mrType;
		this.mrName = mrName;
		this.mrExplain = mrExplain;
		this.mrImage=mrImage;
	}
	//삭제 생성자  Dowoo 2021.04.28
	public MMR_DbAction(int mrNum) {
		super();
		this.mrNum = mrNum;
	}
	
	//이미지
	public MMR_DbAction(String conname, String condate) {
		super();
		this.conname = conname;
		this.condate = condate;
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
		String A = "select mrNum, mrType, mrName, mrExplain from mbtiresult" ;
	   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql =conn_mysql.createStatement();
	        ResultSet rs = stmt_mysql.executeQuery(A);
	        
	        while(rs.next()){
	        	int wkMrNum =rs.getInt(1);
	        	String wkMrType =rs.getString(2);
	        	String wkMrName =rs.getString(3);
	        	String wkMrExplain =rs.getString(4);
	        	
	        	
	        	MMR_Bean bean = new MMR_Bean(wkMrNum, wkMrType, wkMrName, wkMrExplain);
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
	      String A = "select mrNum, mrType, mrName, mrExplain, mrImage from mbtiresult "; 
	      String B = "where mrNum = ";
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(A + B + mrNum);

	          if(rs.next()){
	        	  
	          	int wkMrNum=(rs.getInt(1));
	          	String wkMrType =rs.getString(2);
	        	String wkMrName =rs.getString(3);
	        	String wkMrExplain =rs.getString(4);
	        	
	        	//이미지
	        	data_Enviroment_define.filename = data_Enviroment_define.filename + 1;
            	File file = new File(Integer.toString(data_Enviroment_define.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(5);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
	          	
	          	bean = new MMR_Bean(wkMrNum, wkMrType, wkMrName, wkMrExplain);

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

			String A = "insert into mbtiresult (mrType, mrName, mrExplain, mrImage";
			String B = ") values (?,?,?,?)";

			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, mrType.trim());
			ps.setString(2, mrName.trim());
			ps.setString(3, mrExplain.trim());
			ps.setBinaryStream(4, mrImage);
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

			String A = "update mbtiresult set mrType = ?, mrName = ?, mrExplain = ?, mrImage = ?";
			String B = "where mrNum = ? ";
		          
		     ps = conn_mysql.prepareStatement(A+B);
		     ps.setString(1, mrName.trim());
		     ps.setString(2, mrName.trim());
		     ps.setString(3, mrExplain.trim());
		     ps.setBinaryStream(4, mrImage);
		     ps.setInt(5, mrNum);
		     
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
