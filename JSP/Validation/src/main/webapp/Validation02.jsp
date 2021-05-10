<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkLogin() {
		var form = document.loginForm
		if(form.id.value == ""){
			alert("아이디를 입력해 주세요!");
			form.id.focus(); // 포커스를 id에 두는것 
			return false;
		}else if(form.passwd.value == ""){
			alert("패스워드를 입력해 주세요!");
			form.passwd.focus(); 
			return false;
		}
		form.submit();
	}

</script>
<body>
	<form name="loginForm" action="validation02_Process.jsp" method="post" >
		<p>아이디 : <input type="text" name="id"> </p>
		<p>비밀번호 : <input type="password" name="passwd"> </p>
		<p><input type="button" value="전송" onclick="checkLogin()">  <!--  버튼 꼭 기억하기! submit와 button의 차이를 알것! -->
		
		 
	
	</form>
</body>
</html>