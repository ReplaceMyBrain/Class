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
				<td > 이름 </td>
				<td> <input type="text" name="aName" size = "70"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <input type="text" name="aContent" size = "70" > </td>
			</tr>
			<tr>
				<td> 주소 </td>
				<td> <input type="text" name="aAddress" size = "70" > </td>
			</tr>
			<tr>
				<td> 전자우편 </td>
				<td> <input type="text" name="aEmail" size = "70" > </td>
			</tr>
			<tr>
				<td> 관계 </td>
				<td> <input type="text" name="aRelation" size = "70" > </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>