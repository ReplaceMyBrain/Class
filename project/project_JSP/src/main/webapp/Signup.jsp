<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
 <style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
    *{margin:0; padding: 0; box-sizing: border-box;}
    
    body {
      margin: 0;
      padding: 0;
      background: #DDD;
      color: #222;
      font-family: 'Noto Sans KR', sans-serif;
    }
    
    #register-box {
      position: relative;
      margin: 5% auto;
      width: 400px;
      height: 670px;
      background: #FFF;
      padding:20px 40px;
      box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.3);
    }
    #register-box a {
      text-decoration: none;
    }
   
   h1 {
      margin: 0 0 25px 0;
      font-weight: 300;
      font-size: 28px;
      text-align: center;
      }
    
    input[type="text"],
    input[type="password"] {
      display: block;
      box-sizing: border-box;
      margin-bottom: 15px;
      padding: 10px;
      width: 100%;
      height: 32px;
      border: none;
      border-bottom: 1px solid #AAA;
      font-weight: 400;
      font-size: 12px;
      transition: 0.2s ease;
    }
    
    button {
      display: block;
      width: 75px;
      height: 25px;
      margin-top: -25px;
      margin-left: 60px;
      margin-bottom: 0px;
      padding: 0px;
      color: black;
      font-size: 10px;
      background: #16a085;
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    button:hover,
    button:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    button:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    .addressSearch{
     margin-left: 40px;
    }



    input[type="button"] {
      margin-top: 20px;
      text-align: center;
      width: 100%;
      height: 32px;
      background: #16a085;
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    input[type="button"]:hover,
    input[type="button"]:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    input[type="button"]:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    
    input[type="checkbox"]{
     width: 20px;
     height: 20px;
     margin-right: 10px
    }
    
    .check{
    display: block;
    margin-top: 10px;
    font-size: 13px;
    color: #222;
   
    }
    .check a {
    text-decoration: none;
   	color: black;
 
   	}
   	
   	.email-msg1 {
   	display: none;
   	color: blue;
   	margin-top: -20px;
   	
   	}
   	.email-msg2 {
   	display: none;
   	color: red;
   	margin-top: -20px;
   	
   	}
</style>  
    <title>회원가입</title>
</head>
<script type="text/javascript">	
	

	function checkRegister() {	
		var form = document.registerForm;
		
		//이메일,주소 안됨... 이유좀..//
		
		// 비밀번호 정규식
		var rePw = /^[0-9]{4,20}$/; 
		// 이름 정규식
		var reName = /^[가-힣]{1,20}$/;
		// 휴대폰 번호 정규식
		var reTel = /^[0-9]{10,11}$/;
		
		//비밀번호 확인
		var pw = form.pw.value; 
		pw=pw.trim();
		var pw2 = form.pw2.value; 
		pw2=pw2.trim();
		
		if(!rePw.test(form.pw.value)){
			alert("비밀번호는 4~20자 숫자만 입력해야 합니다.");
			form.pw.select(); 
			return;
		}
		if(pw != pw2){ 
			alert("비밀번호가 일치 하지않습니다.") 
			form.pw.select();  
			return;
		}
		if(!reName.test(form.name.value)) {
			alert("이름은 1~20자 한글만 입력해야 합니다.")
			form.name.select();
			return;
		}
		if(!reTel.test(form.tel.value)){
			alert("핸드폰 번호는 숫자만 가능하며 11~12자리 이내로 입력 가능 합니다");
			form.tel.select(); 
			return;
		}
		if(form.agreechk.checked==false){
			alert("개인정보처리방침에 동의해주세요.");
			return;
		}
		alert(form.name.value + "회원가입이 완료되었습니다!")
		form.submit();
	}	
	function emailCheck(){
			/* AJAX */
			$.ajax({
				url:"/UserEmailCheckCommand.java",
				type: "post",
				data: {email:$("#email").val()},
				success:function(result){
					console.log("1=중복x 0=중복o : "+result);
					if (result == 1)  {
						$("#email_check").text("사용 가능한 이메일입니다:)");
						$("#email_check").css('color', 'blue');
					}
					else{
						$("#email_check").text("사용중인 이메일입니다.");
						$("#email_check").css("color", "red");
					} 
				}
			});
	}
			
	
</script> 

<body>
    <div id="register-box">
      <h1>회원가입</h1> 
      <form action="register.do" method="post" name="registerForm">
        <span>이메일</span><button class="duplicate" onclick="emailCheck()" type="button">중복확인</button>
        <input type="text" name="email"  id=email placeholder="이메일을 입력해주세요." />
        <div class=check_font" id=email_check></div>
        <span>비밀번호</span><br>
        <input type="password" name="pw" id=pwCheck placeholder="비밀번호를 입력해주세요" />
        <span>비밀번호 확인</span> <!-- 추후에 추가 <span id=pw>일치</span><br> -->
        <input type="password" name="pw2" id=pwDuplicateCheck placeholder="입력한 비밀번호를 입력해주세요" />
        <span>이름</span><br>
        <input type="text" name="name" id=nameCheck placeholder="이름을 입력해주세요." />
        <span>핸드폰번호</span><br>
        <input type="text" name="tel" id=telCheck placeholder="-없이 핸드폰번호를 입력해주세요." />
        <span>주소</span><a href=""><button class="addressSearch" type="button">주소찾기</button></a>
        <input type="text" name="address" id=addressCheck placeholder="주소찾기를 눌러주세요." />
        <span>GitHub아이디(선택)</span><br>
        <input type="text" name="github" placeholder="GitHub아이디를 입력해주세요." />
     	 <div class="check">
      	 	<input type="checkbox" name="agreechk"><a href="PrivacyPolicy.do"  target='_blank'>개인정보처리방침</a>에 동의합니다
    	 </div>
        <input type="button" onclick="checkRegister()" value="회원가입" />
     </form>
   </div>
   
</body>
</html> 