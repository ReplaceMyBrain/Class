package com.springlec.oneline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.oneline.dto.Dto;
import com.springlec.oneline.util.Constant;

public class Dao {
	
//	DataSource dataSource;
	JdbcTemplate template;
	
	public Dao() {
		this.template = Constant.template;
	}
	
	public ArrayList<Dto> list(){
		String query = "select no,name,title,date from board";
		return (ArrayList<Dto>) template.query(query, new BeanPropertyRowMapper<Dto>(Dto.class));
	}
	
	public void delete(final String strID) {
		String query = "delete from board where no = ?";
		this.template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, strID);
				
			}
		});
	}
	
	public void write(final String name, final String title) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into board (name,title,date) values(?,?,now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, title);
			
				return preparedStatement;
			}
		});
	}
	

}
