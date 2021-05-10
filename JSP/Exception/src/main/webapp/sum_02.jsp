<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"errorPage="DataError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈 결과</title>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int result = num1+num2;
%>

<%=num1 %> + <%=num2 %> = <%=result %>
</body>
</html>