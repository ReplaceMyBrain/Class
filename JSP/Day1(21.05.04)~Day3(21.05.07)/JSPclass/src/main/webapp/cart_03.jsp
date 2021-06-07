<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 저장 결과</title>
</head>
<body>
	<h1>상품 선택 저장 결과</h1>
<h6>
<%
	request.setCharacterEncoding("utf-8");
	String str = request.getParameter("result");
	
	if(str.equals("success")){
		out.print("저장되었습니다");
	}else {
		out.print("저장에 문제가 생겼습니다.");
	}
%>
</h6>	
	<br><br><br>
	<form action="cart_04.jsp">
	<input type="submit"  value="저장 결과 불러오기">
	
	</form>

</body>
</html>