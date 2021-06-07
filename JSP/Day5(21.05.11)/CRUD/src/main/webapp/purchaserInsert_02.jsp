<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String result = "";
	
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	
	session.setAttribute("USERID", userid);
	session.setAttribute("NAME", name);
	session.setAttribute("TEL", tel);
	session.setAttribute("ADDRESS", address);
	
	


	//-----
	
	String url_mysql = "jdbc:mysql://localhost/wtest?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	PreparedStatement ps =null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		String A = "insert into purchaserinsert (userid,name,tel,address,insertdate";
		String B = ") values (?,?,?,?,now())";
		
		ps = conn_mysql.prepareStatement(A+B);
		ps.setString(1, userid);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, address);

		ps.executeUpdate();
		
		conn_mysql.close();
		result="success";
	
		
	}catch(Exception e){
		e.printStackTrace();
		result="fail";
		
	}
	
	response.sendRedirect("purchaserInsert_03.jsp?result=" + result);

	
	//-----
	
%>