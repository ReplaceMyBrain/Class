package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DonateDao {

	DataSource dataSource;
	
	public DonateDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	//기부하기
		public void Donate(int IntDonate) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "INSERT INTO donate (DONATE_AMOUNT) values (?)";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, IntDonate);		
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
		
		//기부액의 합 보여주기
		public int DonateSum() {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			int result = 0;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select sum(DONATE_AMOUNT) from donate";
				preparedStatement = connection.prepareStatement(query);

				resultset = preparedStatement.executeQuery();
				
				if (resultset.next()) {
					  int sumDonate = resultset.getInt("sum(DONATE_AMOUNT)");
			    	  result = sumDonate;
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

}
