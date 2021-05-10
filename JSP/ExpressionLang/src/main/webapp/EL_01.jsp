<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EL_02.jsp">
	아이디 : <input type="text" name="id"> <br>
	다음중 회원님이 키우고 있는 애완동물을 선택하십시오<br>
	강아지<input type="checkbox" name="animal" value="강아지">
	고양이<input type="checkbox" name="animal" value="고양이">
	거북이<input type="checkbox" name="animal" value="거북이">
	<br><br>
	<input type="submit" value="확인">
	<input type="reset" value="취소">
	</form>
</body>
</html>