package com.javalec.PanelManageMbtiResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javalec.Datadefine.data_Enviroment_define;

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
	 
	public MMR_DbAction(int mrNum) {
		super();
		this.mrNum = mrNum;
	}
	
	
	
	//-----------------
	//Method
	//-----------------
	
	
	//삭제 Dowoo 2021.04.28
	public boolean DeleteAction() {
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
