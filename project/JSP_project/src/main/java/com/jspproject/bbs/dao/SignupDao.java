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
	
	//이메일 중복확인
	public String emailCheck(String StrEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select email from user where email = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, StrEmail);
			
			resultset = preparedStatement.executeQuery();
			
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
	
	//전화번호 중복확인
	public String telCheck(String StrTel) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select tel from user where tel = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, StrTel);
			
			resultset = preparedStatement.executeQuery();
			
			if (resultset.next()) {
				  String tel = resultset.getString("tel");
		    	  result = tel;
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
	public void register(String email, String name, String pwd, String address ,String tel , String git) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "INSERT INTO user (EMAIL, NAME, PWD, ADRESS, TEL, GIT, CREATEDATE, ADMIN) values (?,?,?,?,?,?,now(),0)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, pwd);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, tel);
			preparedStatement.setString(6, git);
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
