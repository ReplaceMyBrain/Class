package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.PostDto;


public class MyPostDao {

	DataSource dataSource;
	
	public MyPostDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	// 전체 불러오기.
	public ArrayList<PostDto> mylist(String userId, int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "SELECT I_NUM AS NUM, I_TITLE AS TITLE, I_CONTENT AS CONTENT, I_IMAGE AS IMAGE, I_CATEGORY AS CATEGORY, I_HITS AS HITS FROM ITEM WHERE I_NUM IN (SELECT ITEM_I_NUM FROM WRITE_ITEM WHERE USER_EMAIL = "+ userId;
			String query2 = ") UNION SELECT T_NUM AS NUM, T_TITLE AS TITLE, T_CONTENT AS CONTENT, T_IMAGE AS IMAGE, T_CATEGORY AS CATEGORY, T_HITS AS HITS FROM TIP WHERE T_NUM IN (SELECT TIP_T_NUM FROM WRITE_TIP WHERE USER_EMAIL = "+ userId + ") LIMIT ?, ?";

			int offset = start - 1;
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("NUM");
				String title = resultset.getString("TITLE");
				String content = resultset.getString("CONTENT");
				String imgSrc = resultset.getString("IMAGE");
				String category = resultset.getString("CATEGORY");
				int views = resultset.getInt("HITS");
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
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
	
	// 물건만 불러오기.
	public ArrayList<PostDto> myItemList(String userId, int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT * FROM ITEM WHERE I_NUM IN (SELECT ITEM_I_NUM FROM WRITE_ITEM WHERE USER_EMAIL = "+ userId + ") LIMIT ?, ?";
			
			int offset = start - 1;
			// order by date로
			preparedStatement = connection.prepareStatement(query);
			
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt(1);
				String title = resultset.getString(2);
				String content = resultset.getString(3);
				String imgSrc = resultset.getString(4);
				String category = resultset.getString(5);
				int view = resultset.getInt(6);
				PostDto dto = new PostDto(num, title, content, imgSrc, category, view);
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
	
	// 팁 및 아이디어만
	public ArrayList<PostDto> myTipList(String userId, int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT * FROM TIP WHERE T_NUM IN (SELECT TIP_T_NUM FROM WRITE_TIP WHERE USER_EMAIL = "+ userId +") LIMIT ?, ?";
			
			int offset = start - 1;
			// order by date로
			preparedStatement = connection.prepareStatement(query);
			
			
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			System.out.println(resultset);
			while(resultset.next()) {
				int num = resultset.getInt(1);
				String title = resultset.getString(2);
				String content = resultset.getString(3);
				String imgSrc = resultset.getString(4);
				String category = resultset.getString(5);
				int view = resultset.getInt(6);
				PostDto dto = new PostDto(num, title, content, imgSrc, category, view);
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
	
	public int selectAll(String userId){
		int count=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "SELECT COUNT(*) FROM ITEM WHERE I_NUM IN (SELECT ITEM_I_NUM FROM WRITE_ITEM WHERE USER_EMAIL = "+ userId + ")";
			String query2 = " UNION SELECT COUNT(*) FROM TIP WHERE T_NUM IN (SELECT TIP_T_NUM FROM WRITE_TIP WHERE USER_EMAIL = "+ userId + ")";
			preparedStatement = connection.prepareStatement(query1+query2);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				count += resultset.getInt(1);
			}
			System.out.println(count);
		}catch(Exception e) {
			System.out.println("list-count fail");
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
		return count;
	}
	
	public int selectTip(String userId){
		int count=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT COUNT(*) FROM TIP WHERE T_NUM IN (SELECT TIP_T_NUM FROM WRITE_TIP WHERE USER_EMAIL = "+ userId + ")";
			preparedStatement = connection.prepareStatement(query);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				count += resultset.getInt(1);
			}
			System.out.println(count);
		}catch(Exception e) {
			System.out.println("list-count fail");
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
		return count;
	}
	
	public int selectItem(String userId){
		int count=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT COUNT(*) FROM ITEM WHERE I_NUM IN (SELECT ITEM_I_NUM FROM WRITE_ITEM WHERE USER_EMAIL = "+ userId + ")";
			preparedStatement = connection.prepareStatement(query);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				count += resultset.getInt(1);
			}
			System.out.println(count);
		}catch(Exception e) {
			System.out.println("list-count fail");
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
		return count;
	}

}
