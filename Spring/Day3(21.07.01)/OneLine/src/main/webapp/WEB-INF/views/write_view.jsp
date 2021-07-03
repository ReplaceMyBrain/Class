<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="write" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
				
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>

</body>
</html>