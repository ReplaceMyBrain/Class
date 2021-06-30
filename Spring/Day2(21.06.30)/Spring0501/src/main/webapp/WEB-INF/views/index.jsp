<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	Get<br>
	<form action="student" method="get">
	
		student id : <input type="text" name="id"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	
		post<br>
	<form action="student" method="post">
	
		student id : <input type="text" name="id"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	
		Get2<br>
	<form action="studentGet" method="get">
	
		student id : <input type="text" name="id"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	
			post2<br>
	<form action="studentPOST" method="post">
	
		student id : <input type="text" name="id"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	
	
</body>
</html>