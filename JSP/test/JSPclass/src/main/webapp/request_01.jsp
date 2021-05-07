<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 입력</title>
</head>
<body>
	이름을 입력하고 확인 버튼을 누르세요.
	<br><br>
	<form action ="request_02.jsp" method="post"> <%//get으로 test하고 post를 쓴다. %>
		이름 : <input type="text" name="yourname">
				<input type="submit"  value="확인">
	</form>	
</body>
</html>
