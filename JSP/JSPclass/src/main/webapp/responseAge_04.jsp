<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성인확인</title>
</head>
<body>
<% 
	String age = request.getParameter("age");
%>
	<h1>미성년자</h1> <br>
	
	당신의 나이는 <%=age %> 이므로 주류 구매가 불가능합니다.<br>
	<a href="responseAge_01.jsp">처음으로 이동</a>

	
</body>
</html>