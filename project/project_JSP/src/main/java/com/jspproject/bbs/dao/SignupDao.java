package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SignupDao {
	
	DataSource dataSource;

	public SignupDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//이메일 중복확인 아직 구현 못했음 내일 다시 해볼 예정.
	public String emailCheck(String Stremail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select email from user where email = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, Stremail);
			preparedStatement.executeUpdate();
			
			if (resultset.next()) {
				String email = resultset.getString("email");
		    	  result = email;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		return result;
	}
	//회원가입
	public void register(String email, String pw, String name, String tel, String address, String github) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into user values (?,?,?,?,?,?,'0000-00-00 00:00:00',now(),0)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pw);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, tel);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, github);
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
	}
	
	
	
	
}//--------
