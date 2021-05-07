<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Answer</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	int num1, num2, selNum1, selNum2;
	
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	selNum1 = Integer.parseInt(request.getParameter("selNum1"));
	selNum1 = Integer.parseInt(request.getParameter("selNum2"));
%>

	1번의 답은 : <%= num1+num2 %><br>
	2번의 답은 : <%= num1*num2 %>

</body>
</html>
