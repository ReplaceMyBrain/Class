<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택 저장 내용</title>
</head>
<body>

	<h2>파일 저장 결과</h2>
<%
	request.setCharacterEncoding("utf-8");
	String quantity = request.getParameter("quantity");
	String size = request.getParameter("size");
	String color = request.getParameter("color");
	
	String filename = "file.txt";
	
	PrintWriter writer = null;
	String result; 
	
	try{
		String filePath = application.getRealPath("/" + filename);
		writer = new PrintWriter(filePath);
		writer.print("수량 :" + quantity + "<br>");
		writer.print("크기 :" + size +"<br>");
		writer.print("색상 :" + color);
		result = "success";
	}catch(Exception e){
		result = "fail";
	}finally{
		try{
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	response.sendRedirect("cart_03.jsp?result="+ result);

%>	
</body>
</html>