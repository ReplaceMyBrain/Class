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
	String[] arr = {"불고기 백반", "오므라이스", "김치찌개" };
	request.setAttribute("MENU", arr);
%>
	<jsp:forward page="jstl_10.jsp"/>

</body>
</html>