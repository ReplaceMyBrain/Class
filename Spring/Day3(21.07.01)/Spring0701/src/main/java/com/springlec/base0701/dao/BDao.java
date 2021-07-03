package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {
	
//	DataSource dataSource;
	JdbcTemplate template;
	
	
	public BDao() {
		// TODO Auto-generated constructor stub
		this.template = Constant.template;
		
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	// 초기화면(검색)
	
	public ArrayList<BDto> list(){
		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values(?,?,?,now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
			
				return preparedStatement;
			}
		});
	}
	
	public BDto contentView(String strID) {
		
		String query = "select * from mvc_board where bId =" + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public void delete(final String strID) {
		String query = "delete from mvc_board where bId = ?";
		this.template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, strID);
				
			}
		});
	}

	public void modiey(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setString(4, bId);
				
				
			}
		});		
		
	}
	
} // BDao
