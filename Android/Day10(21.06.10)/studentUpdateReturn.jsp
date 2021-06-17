<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>        
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String dept = request.getParameter("dept");
	String phone = request.getParameter("phone");	
		
//------
	String url_mysql = "jdbc:mysql://localhost/education?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";

	int result = 0; // 입력 확인 

	PreparedStatement ps = null;
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
	
	    String A = "update student set sname=?, sdept=?, sphone=? where scode=?";
	
	    ps = conn_mysql.prepareStatement(A);
	    ps.setString(1, name);
	    ps.setString(2, dept);
	    ps.setString(3, phone);
		ps.setString(4, code);
		
		result = ps.executeUpdate();
%>
		{
			"result" : "<%=result%>"
		}

<%		
	    conn_mysql.close();
	} 
	catch (Exception e){
%>
		{
			"result" : "<%=result%>"
		}
<%		
	    e.printStackTrace();
	} 
	
%>

