<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부를 이용한 덧셈</title>
</head>
<body>

 2+1 = <%= decadd(2,1) %> <br>
 3+1 = <%= decadd(3,1) %> <br>
 4+1 = <%= decadd(4,1) %> <br>
 5+1 = <%= decadd(5,1) %> <br>

</body>
</html>
<%!
	public int decadd (int a, int b) {
		return a+b;
}
		
%>