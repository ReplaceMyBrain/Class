<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		margin: 200px;
		margin-top: 100px;
		margin-bottom: 0px;
	}
	
		
	.title {
		margin: 50px;
		margin-bottom: 8px;
	}
	
	.content {
		margin: 50px;
		margin-top: 8px;
		text-overflow: ellipsis;
		color: rgb(117,117,117);
	}
	.views {
		color: rgb(117,117,117);
	}
</style>
</head>
<body>
	<div>
	<c:forEach items="${list}" var="dto">
		<div class="container">
			<div class = "textArea">
				<div class = "title">
					<h2> ${dto.title } </h2>
				</div>
				<div class = "content">
					${dto.content }
				</div>
				<hr class = "line">
			</div>
		</div>
	</c:forEach>
	</div>
	<%@include file ="Footer.jsp" %> 
</body>
</html>