<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
	<h3>MVC 게시판</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto"><!-- 리스트커멘드에서 정해줌 아이템즈는  -->
		<tr>
			<td>${dto.bId }</td>
			<td>${dto.bName }</td>
			<td><a href="content_view.do?bId=${dto.bId}">${dto.bTitle }</a></td>
			<td>${dto.bDate }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="write_view.do">글작성</a></td>
		</tr>
		
	</table>
</body>
</html>