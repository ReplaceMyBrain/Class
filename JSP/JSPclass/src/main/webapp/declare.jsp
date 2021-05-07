<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>
<%
	int i = 10;
	String str = "I have a dream.";

	out.println("i = " + i + "<br>");
	out.println("str = " + str + "<br>");
	out.println("sum = " + sum(12,15) + "<br>");
%>

</body>
</html>

<%!
	public int sum(int a, int b) {
		return a+b;
}
	
%>
