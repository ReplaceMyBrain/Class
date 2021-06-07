<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2> 회원 가입 결과 </h2><br>
가입되었습니다.<br>

<h2> 가입내용</h2><br>
아이디 : ${ID}
패스워드 : ${PW}
성명 : ${NAME}

<% session.invalidate(); %>


</body>
</html>