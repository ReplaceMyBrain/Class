package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.NoticeDto;


public class NoticeDao {

	DataSource dataSource;
	
	public NoticeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public ArrayList<NoticeDto> list() {
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT N_NUM, N_TITLE, N_CONTENT, N_HITS FROM NOTICE";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("N_NUM");
				String title = resultset.getString("N_TITLE");
				String content = resultset.getString("N_CONTENT");
				int views = resultset.getInt("N_HITS");
				
				NoticeDto dto = new NoticeDto(num, title, content, views);
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
