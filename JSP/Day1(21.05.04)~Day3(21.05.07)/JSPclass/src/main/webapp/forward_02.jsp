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
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	request.setAttribute("ADD", num1 + num2);
	request.setAttribute("SUB", num1 - num2);
	request.setAttribute("MUL", num1 * num2);
	request.setAttribute("DIV", (double)num1 / (double)num2); 
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_03.jsp");
	dispatcher.forward(request, response); //한꺼번에 넘길수 있다. 날아갈때는 response이지만 받을 때는 request로 받게된다.
%>
</body>
</html>