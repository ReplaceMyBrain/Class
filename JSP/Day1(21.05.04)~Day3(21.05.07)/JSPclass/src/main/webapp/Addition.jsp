<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition</title>
</head>
<body>
	<%
		int a =30;
		int b =20;
		int addition =a+b;
		int sub =a-b;
		int mul =a*b;
		int div =a/b;
		int mod =a%b;

	%>
	
	<%=a %> + <%=b %> = <%=addition %> <br>
	<%=a %> - <%=b %> = <%=sub %> <br>
	<%=a %> * <%=b %> = <%=mul %> <br>
	<%=a %> / <%=b %> = <%=div %> <br>
	<%=a %> % <%=b %> = <%=mod %> <br>
	
</body>
</html>