package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PwSearchDao {


	DataSource dataSource;
		
	public PwSearchDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String pwSearch(String strEmail, String strTel) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
				
			try {
				connection = dataSource.getConnection();
					
				String query = "SELECT pw FROM user WHERE email=? and tel=?";
				preparedStatement = connection.prepareStatement(query);
					
				preparedStatement.setString(1, strEmail);
				preparedStatement.setString(2, strTel);
						
				resultset = preparedStatement.executeQuery();
					
		      if(resultset.next()) {
		    	  String pw = resultset.getString("pw");
		    	  result = pw;
		      } 
		    } catch (Exception e) {
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
				return result;
			}
	
}//-----------------