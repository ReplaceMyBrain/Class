<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력 결과</title>
</head>
<body>
<%
	String name, id, pw, majorOne, protocol;
	String[] hobbies, majors;

	request.setCharacterEncoding("utf-8");
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	hobbies = request.getParameterValues("hobby"); //체크박스 다중선택
	majors= request.getParameterValues("major"); //라디오 
	majorOne= request.getParameter("major");//라디오 둘다 가능 하지만 하나만 들어옴.
	protocol= request.getParameter("protocol");
	
	
%>

	이름 : <%=name %><br>
	아이디 : <%=id %><br>
	패스워드 : <%=pw %><br>
	취미 : <%=Arrays.toString(hobbies) %><br>
	전공 : <%=Arrays.toString(majors) %> <br> 
	전공2 : <%=majorOne %><br> 
	Protocol :<%=protocol %><br> 
	
</body>
</html>