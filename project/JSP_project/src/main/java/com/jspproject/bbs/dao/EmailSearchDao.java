package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EmailSearchDao {

	DataSource dataSource;
		
	public EmailSearchDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
	public String emailSearch(String strName, String strTel) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
				
			try {
				connection = dataSource.getConnection();
					
				String query = "SELECT email FROM user WHERE name=? and tel=?";
				preparedStatement = connection.prepareStatement(query);
					
				preparedStatement.setString(1, strName);
				preparedStatement.setString(2, strTel);
						
				resultset = preparedStatement.executeQuery();
					
		      if(resultset.next()) {
		    	  String email = resultset.getString("email");
		    	  result = email;
		      } 
		    } catch (Exception e) {
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
			
		
		
	}//--------------