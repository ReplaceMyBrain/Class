<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	
	String url_mysql ="jdbc:mysql://localhost/wtest?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	PreparedStatement ps =null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		String A = "delete from purchaserinsert where userid= ?";
		
		ps = conn_mysql.prepareStatement(A);
		ps.setString(1, userid);
		ps.executeUpdate();
		
		conn_mysql.close();

	}catch(Exception e){
		e.printStackTrace();
		
	}
	response.sendRedirect("purchaserSelect_01.jsp");
%>
</body>
</html>