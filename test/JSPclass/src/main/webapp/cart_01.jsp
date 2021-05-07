<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택</title>
</head>
<body>
	<form action="cart_02.jsp">
	수량 : <input type="text" name = "quantity" size = "10"> <br><br>
	크기 : <input type="radio" name = "size" value="대" >대
			<input type="radio" name = "size" value="중" checked="checked">중
			<input type="radio" name = "size" value="소" >소<br><br>
	색상 : <select name = "color">
			<option value = "베이지"> 베이지 </option>
			<option value = "브라운"> 브라운 </option>
			<option value = "카키" selected="selected"> 카키 </option>
		</select><br><br>
	
	<input type="submit" value="저장">
	
	</form>

</body>
</html>