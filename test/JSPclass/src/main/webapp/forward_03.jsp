<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산 결과</title>
</head>
<body>

	덧셈 : <%= request.getAttribute("ADD") %> <br>
	뺄셈 : <%= request.getAttribute("SUB") %> <br>
	곱셈 : <%= request.getAttribute("MUL") %> <br>
	나눗셈 : <%= request.getAttribute("DIV") %> <br>


</body>
</html>