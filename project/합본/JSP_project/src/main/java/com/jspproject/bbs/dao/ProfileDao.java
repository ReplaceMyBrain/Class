package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ProfileDto;



public class ProfileDao {

	DataSource dataSource;

	public ProfileDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public ProfileDto loadProfile(String userId) {
		ProfileDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT EMAIL, NAME, GIT FROM USER WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				String userEmail= resultset.getString("EMAIL");
				String userName= resultset.getString("NAME");
				String userGit= resultset.getString("GIT");
				dto = new ProfileDto(userEmail, userName, userGit);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dto;
	} 


}
