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

	int sum = 0;
	
	for(int i=0; i<=100; i++){
		sum += i;	
	}
	
	out.print("1+2+3+.....99+100 =" + sum);


%>
</body>
</html>