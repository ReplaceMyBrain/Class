<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반갑습니다.</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); // 한글쓸 때 꼭 쓴다!!! 잊지말고 할것! 영어는 문제없다. post쓸때 더더욱 
%>
	안녕하세요,  <%= request.getParameter("yourname") %> 님!

</body>
</html>