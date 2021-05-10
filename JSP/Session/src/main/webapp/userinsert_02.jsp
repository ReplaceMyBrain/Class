<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	//Session에 입력하기
	session.setAttribute("ID", id);
	session.setAttribute("PW", pw);
	session.setAttribute("NAME", name);

%>

<h2>약관</h2>

-------------------------------------------------<br>
1.회원정보는 웹사이트의 운영을 위해서만 사용 됩니다.<br>
2.웹사이트의 정상 운영을 방해하는 회원은 탈퇴 처리 합니다.<br>
-------------------------------------------------<br>
위의 약관에 동의 하십니까?<br>

<form action="userinsert_03.jsp">
	<input type="radio" name="result" value="success"  checked="checked">동의함
	<input type="radio" name="result" value="fail" >동의하지않음
	<input type="submit" value="확인">

</form>

</body>
</html>