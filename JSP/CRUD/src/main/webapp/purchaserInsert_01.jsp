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
		var rePhone = /^[0-9]{11,12}$/;
		
		

		if(!reId.test(form.userid.value)) {
			alert("아이디는 문자로 시작해야 합니다.")
			form.userid.select();
			return;
		}
		if(!reName.test(form.name.value)) {
			alert("이름은 한글만 입력해야 합니다.")
			form.name.select();
			return false;
		}
		if(!rePhone.test(form.tel.value)){
			alert("핸드폰 번호는 숫자만 가능하며 3~4자리 이내로 입력 가능 합니다");
			form.tel.select(); 
			return ;
		}
		
		
		form.submit();
	}

</script>
<body>
	<h3>아래의 항목을 입력후 확인 버튼을 누르세요!</h3><br>

	<form name="loginForm" action="purchaserInsert_02.jsp" method="post">
		<table>
			<tr>
				 <td>사용자ID : </td>
				 <td> <input type="text" name="userid" size="10"></td>	
			</tr>
			<tr>
				 <td>성명 :</td>
				 <td> <input type="text" name="name" size="10"></td>	
			</tr>
			<tr>
				 <td>전화번호 : </td>
				 <td> <input type="text" name="tel" size="10"></td>	
			</tr>
			<tr>
				 <td>주소 : </td>
				 <td> <input type="text" name="address" size="30"></td>	
			</tr>
		</table>
		<input type="button" value="가입하기" onclick="checkLogin()">
	</form>
	
</body>
</html>