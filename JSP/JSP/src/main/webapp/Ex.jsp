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
	
		String b = "<br>";
		int i = 1;
		
		while(i<=9) {
			
			out.print("2*" + i + "=" + (2*i) + b);
			out.print("==========" + b);
			i++;
		
		}
		
	%>



</body>
</html>