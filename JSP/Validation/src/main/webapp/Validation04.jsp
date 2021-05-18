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
		
		//아이디 정규식
		var reId = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]/;
		// 비밀번호 정규식
		var rePw = /^[0-9]{4,12}$/; 
		// 이름 정규식
		var reName = /^[가-힣]{1,12}$/;
		// 휴대폰 번호 정규식
		var rePhone = /^[0-9]{3,4}$/;
		// 이메일 검사 정규식
		var reEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		

		if(!reId.test(form.id.value)) {
			alert("아이디는 문자로 시작해야 합니다.")
			form.id.select();
			return;
		}
		if(!rePw.test(form.pw.value)){
			alert("비밀번호는 숫자만 입력해야 합니다.");
			form.pw.select(); 
			return ;
		}
		if(!reName.test(form.name.value)) {
			alert("이름은 한글만 입력해야 합니다.")
			form.name.select();
			return false;
		}
		if(!rePhone.test(form.phone2.value)){
			alert("핸드폰 번호는 숫자만 가능하며 3~4자리 이내로 입력 가능 합니다");
			form.phone2.select(); 
			return ;
		}
		if(!rePhone.test(form.phone3.value)) {
			alert("핸드폰 번호는 숫자만 가능하며 3~4자리 이내로 입력 가능 합니다")
			form.phone3.select();
			return ;
		}
		if(!reEmail.test(form.email.value)){
			alert("이메일은 이메일 형식을 따라야합니다.");
			form.email.select(); 
			return ;
		}
		
		alert("회원가입이 완료되었습니다!")
		form.submit();
	}

</script>
<body>
<h2>회원가입</h2><br>



<form name="loginForm" action="validation04_Process.jsp" method="post" >
		<p>아이디 : <input type="text" name="id"> </p>
		<p>비밀번호 : <input type="password" name="pw"> </p>
		<p>이름 : <input type="text" name="name"> </p>
		<p>연락처 : 
		<select name="phone1">
			<option value="010" selected ="selected"> 010 </option>
			<option value="02"> 02 </option>
			<option value="031" > 031 </option>
		</select>
		<input type="text" name="phone2" size="5">-<input type="text" name="phone3" size="5"></p>
		<p>이메일 : <input type="text" name="email"> </p>
		
		
		<p><input type="button" value="가입하기" onclick="checkLogin()">  <!--  버튼 꼭 기억하기! submit와 button의 차이를 알것! -->
		
		 
	
	</form>
</body>
</html>