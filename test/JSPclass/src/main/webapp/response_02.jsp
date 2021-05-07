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
	String siteName = request.getParameter("sitename");

	switch(siteName){
		case "naver" :
			response.sendRedirect("https://www.naver.com");
				break;
		case "daum" :
			response.sendRedirect("https://www.daum.com");
				break;
		case "google" :
			response.sendRedirect("https://www.google..com");
				break;
		default:
			response.sendRedirect("http://localhost:8080/JSP(21.05.06)/response_01.jsp");
				break;
	}
%>

</body>
</html>