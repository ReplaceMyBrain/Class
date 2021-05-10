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
	int sum=0;
	for(int cnt =1; cnt<=100; cnt++){
		sum+=cnt;
	}
	request.setAttribute("RESULT", sum);
	
%>
	<jsp:forward page="sact_03.jsp"  />

</body>
</html>