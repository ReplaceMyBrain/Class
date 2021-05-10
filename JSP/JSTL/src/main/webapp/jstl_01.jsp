<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 라이브러리 실행 -->
<c:set var = "num1" value="7" />
<c:set var = "num2" value="9" />
<c:set var = "result" value="${num1*num2 }"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${num1 }과 ${num2 }의 곱은 ${result }입니다.

</body>
</html>