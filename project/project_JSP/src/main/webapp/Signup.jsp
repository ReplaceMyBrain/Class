<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("address1").value = roadAddr;

            }
        }).open();
    }
</script>
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
      height: 800px;
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
      margin-top: 5px;
      padding: 10px;
      width: 100%;
      height: 32px;
      border: none;
      border-bottom: 1px solid #AAA;
      font-weight: 400;
      font-size: 12px;
      transition: 0.2s ease;
    }
    
    label.error{
    display: block;
    color: red;
    font-size: 3pt;
    margin-top: -13px;
    margin-bottom: 5px;
    
	}
	
    
   input[type="button"] {
      display: block;
      width: 60px;
      height: 25px;
      margin-top: -25px;
      margin-left: 80px;
      margin-bottom: 0px;
      padding: 0px;
      color: #FFF;
      font-size: 10px;
      background: #136de4;
      border: none;
      border-radius: 2px;
      
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



    input[type="submit"] {
      margin-top: 7px;
      text-align: center;
      width: 100%;
      height: 32px;
      background: #16a085;
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    input[type="submit"]:hover,
    input[type="submit"]:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    input[type="submit"]:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    
    input[type="checkbox"]{
     width: 15px;
     height: 15px;
     margin-right: 10px;
     margin-bottom: 20px;
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

</style>  
    <title>회원가입</title>
</head>

<script>
//유효성검사
$(function(){
  $.validator.addMethod("regx",function(value,elemqnt,regexpr){
      return regexpr.test(value);
  });  
  $("form").validate({
      //validation이 끝난 이후의 submit 직전 추가 작업할 부분
  		  submitHandler: function() {
          var f = confirm("회원가입을 완료하겠습니까?");
          var form = documenmht.frm;
          if(f){
              return true; 
          } else {
              return false;
          }
      },
      //규칙
      rules: {
    	  email: {
              required : true,
              regx : /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i,
        	  remote: {
                  url: "./UserRegisterCheckServlet",
                  type: "POST",
                  data: {
                	  email: function() {
                      return $( "#email" ).val();
                      }
              	   }
         	   }
          },
          pwd: {
              required : true,
              regx : /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{6,20}$/
          },
          pwd2: {
              required : true,
              equalTo : pwd
          },
          name: {
              required : true,
              regx : /^[가-힣a-zA-z]{1,30}$/
          },
          tel: {
        	  required : true,
            regx : /^[0-9]{11,12}$/
          },
          address1: {
        	  required : true
          },
          address2: {
        	  required : true
          },
          git: {
        	  maxlength : 20
          },
          agreechk: {
        	  required : true
          },
      },
      
      //규칙체크 실패시 출력될 메시지
      messages : {
          email: {
                required : "필수입력사항입니다.",
                regx : "이메일형식을 맞춰주세요",
                remote : "존재하는 아이디입니다"
            },
            pwd: {
                required : "필수입력사항입니다.",
                regx : "비밀번호는 문자,숫자,특수문자 포함 6~20자입니다"
            },
            pwd2: {
                required : "필수입력사항입니다.",
                equalTo : "비밀번호가 맞지 않습니다."
            },
            name: {
                required : "필수입력사항입니다.",
                regx : "이름은 한글,영어 1~30자입니다"
            },
            tel: {
              required : "필수입력사항입니다.",
                regx : "-없이 숫자11~12자리입니다"
            },
            address1: {
              required : "필수입력사항입니다.",
            },
            address2: {
              required : "필수입력사항입니다.",
            },
            git: {
              maxlength : "최대 {0}글자 이하입니다."
            },
            agreechk: {
              required : "개인정보처리방침에 동의해야합니다"
            },
        }
  });
})

</script>
<body>
    <div id="register-box">
      <h1>회원가입</h1> 
      <form action="register.do" method="post" name="frm" id="frm">
        이메일<br>
        <input type="text" name="email"  id="email" placeholder="이메일을 입력해주세요." />
        비밀번호<br>
        <input type="password" name="pwd" id="pwd" placeholder="문자,숫자,특수문자가 포함된 비밀번호를 입력해주세요." />
        비밀번호 확인<br>
        <input type="password" name="pwd2" id="pwd2" placeholder="입력한 비밀번호를 입력해주세요" />
        이름<br>
        <input type="text" name="name" id="name" placeholder="이름을 입력해주세요." />
        핸드폰번호<br>
        <input type="text" name="tel" id="tel" placeholder="-없이 핸드폰번호를 입력해주세요." />
        도로명 주소<input type="button" onclick="sample4_execDaumPostcode()" value="주소 찾기">
        <input type="text" name="address1" id="address1" placeholder="주소찾기를 눌러주세요." readonly />
        <input type="text" name="address2" id="address2" placeholder="상세주소를 입력해주세요." />
        GitHub아이디(선택)<br>
        <input type="text" name="git" id="git" placeholder="GitHub아이디를 입력해주세요." />
     	 <div class="check">
        <a href="PrivacyPolicy.do"  target='_blank'>개인정보처리방침</a>에 동의합니다.<input type="checkbox" name="agreechk" id="agreechk">
    	 </div>
        <input type="submit" id=register value="회원가입" />
     </form>
   </div>
   
</body>
</html> 