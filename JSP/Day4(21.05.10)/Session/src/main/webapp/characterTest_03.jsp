<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성격 테스트 결과</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String animal = request.getParameter("animal");
	session.setAttribute("ANIMAL", animal);
	
%>

당신은 <%=session.getAttribute("FOOD") %> 와(과) <%=session.getAttribute("ANIMAL") %>
을(를) 좋아하는 성격입니다.

<% session.invalidate(); %>



</body>
</html>