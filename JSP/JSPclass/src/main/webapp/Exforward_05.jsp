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
	String str1 = request.getParameter("num1");
	String str2 = request.getParameter("num2");
	
	int num1 = Integer.parseInt(str1);
	int num2 = Integer.parseInt(str2);
	
	
	out.print("첫번째 수: " + str1 + "<br>");
	out.print("두번째 수: " + str2 + "<br>");
%>

	<form action="Exforward_01.jsp">>
		<%=num1 %> / <%=num2 %> = <%= num1/num2 %>		
		<input type="submit" value="초기화면">
	</form>

</body>
</html>