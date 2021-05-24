package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.PostDto;


public class SearchDao {
	DataSource dataSource;
	
	public SearchDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PostDto> serachList(String where, String searching, String codition) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM "+ where +" where " + codition;
			String searchQuery = " LIKE '%" + searching + "%'";
			System.out.println(query + searchQuery);
			preparedStatement = connection.prepareStatement(query + searchQuery);
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt(1);
				String title = resultset.getString(2);
				String content = resultset.getString(3);
				String image = resultset.getString(4);
				String category = resultset.getString(5);
				int views = resultset.getInt(6);
				
				PostDto dto = new PostDto(num, title, content, image, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
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
		return dtos;
	}
		
}
