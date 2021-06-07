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

	int age = Integer.parseInt(request.getParameter("age"));

	if(age>=20){
		response.sendRedirect("responseAge_03.jsp?age=" + age);
		
	}
	if(age<20){
		response.sendRedirect("responseAge_04.jsp?age=" + age);
	}
%>

</body>
</html>