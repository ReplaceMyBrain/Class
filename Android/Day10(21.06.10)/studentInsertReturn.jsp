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
	
	    String A = "insert into student (scode, sname, sdept, sphone";
	    String B = ") values (?,?,?,?)";
	
	    ps = conn_mysql.prepareStatement(A+B);
	    ps.setString(1, code);
	    ps.setString(2, name);
	    ps.setString(3, dept);
		ps.setString(4, phone);
		
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

