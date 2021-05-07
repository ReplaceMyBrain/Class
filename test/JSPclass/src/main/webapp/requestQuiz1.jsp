<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz1</title>
</head>
<body>
	<form action="requestAnswer.jsp" method="post">
	<input type="text" name="num1" size="10"> + 
	<input type="text" name="num2" size="10"><br>
	
	<select name=selNum1>
	<%
	for(int i=1; i<=999; i++){
		out.print("<option value=\""+ i +"\">"+i+"</option>");
	}
	%>
	</select>
	
	x
	
	<select name=selNum2>
	<% 
	for(int i=1; i<=999; i++){
		out.print("<option value=\""+ i +"\">"+i+"</option>");
	}
	%>
	</select>
	
	<br>
	<input type="submit" value="OK">
	
	</form>
</body>
</html>