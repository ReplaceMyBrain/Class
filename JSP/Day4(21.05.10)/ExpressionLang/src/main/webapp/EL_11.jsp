<%@page import="java.util.ArrayList"%>
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
	ArrayList<String> items = new ArrayList<String>();
	items.add("딸기");
	items.add("오렌지");
	items.add("복숭아");
	
	request.setAttribute("FRUITS", items);
	
	
//	RequestDispatcher dispatcher = request.getRequestDispatcher("EL_12.jsp");
// 	dispatcher.forward(request, response);
	
%>
	<jsp:forward page="EL_12.jsp" />
</body>
</html>