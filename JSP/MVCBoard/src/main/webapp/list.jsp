<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list }" var ="dto">
		<tr>
			<td>${dto.bId }</td>
			<td>${dto.bName }</td>
			<td>${dto.bTitle }</td>
			<td>${dto.bDate }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>