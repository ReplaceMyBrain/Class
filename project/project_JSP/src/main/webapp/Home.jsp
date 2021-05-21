<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

 *{margin:0; padding: 0; box-sizing: border-box;
  list-style: none;}
 body{
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    height: 100vh;
    background-size: cover;
  }

  .vid-header{
    height: 100vh;
    display: flex;
  }
  .fullscreen-vid-wrap{
    position: absolute;
    top:0;
    left:0;
    width: 100%;
    height: 100vh;
    overflow: hidden;
  }
  .fullscreen-vid-wrap video{
    min-width: 100%;
    min-height: 100%;
  }
  
  .login-form {
    position: absolute; z-index: index 1;;
    margin-left: 75%;
    margin-top: 10%;
    background: linear-gradient(rgba(204, 204, 204, 0.3),rgba(71, 71, 71, 0.3));
    width: 350px;
    padding:40px 30px;
    border-radius: 10px;
    box-shadow: 12px 12px 20px #000;

    }
 
  .login-form h1 {
    font-size: 32px; color: #fff;
    text-align: center;
    margin-bottom: 30px;
  }
  .int-area {
    width: 100%; position: relative;
    margin-top: 20px;}

  .int-area:first-child {margin-top: 0;}
  .int-area input{
    width :100%;
    padding: 20px 10px 10px;
    background-color: transparent;
    border:none;
    border-bottom: 1px solid #fff;
    font-size: 18px; color: #fff;
    outline: none;
    }
  .int-area label {
    position: absolute; left: 10px; top:15px;
    font-size: 13px; color: #fff;
    transition: top .5s ease;
  }

  .int-area label.warning {
    color: red !important;
    animation: warning .2s ease;
    animation-iteration-count:3;
  }

  @keyframes warning {
     0% {transform: translateX(-8px);}
     25% {transform: translateX(8px);}
     50% {transform: translateX(-8px);}
     75% {transform: translateX(8px);}
  }

  .int-area input:focus + label,
  .int-area input:valid + label{
    top: -2px;
    font-size: 10px; color: rgb(0, 155, 216);
  } 
  
  .btn-login {margin-top:  10px;}
  .btn-login button {
    width: 100%; height: 40px;
    background: #fff;
    color: rgb(0, 0, 0);
    font-size: 20px;
    border: none;
    border-radius: 25px;
    margin-bottom: 20px;
    margin-top: 15px;
  }

  .signup{
      margin-top: 60px;
      text-align: center;
  }
  .signup span{
    font-size: 16px;
    color: rgb(182, 179, 179);
  }
  
  .signup a {
    font-size: 20px; color:rgb(0, 155, 216);
    text-decoration: none;
  }

  .caption {
      text-align: center;
  }
  .caption a {
     font-size: 15px; color:rgb(182, 179, 179);
     text-decoration: none;
  }
  #naver_id_login {
    position: absolute;
  	margin-left: 20px;
  
  }
  
  #kakao_id_login a {
    position: absolute;
    margin-left: 160px;
  }
  #kakao_id_login img {
    width: 100px;
    height: 40px;
  }

</style>
  <title>나는야개발자</title>
</head>
<body>

    <header class="vid-header container">
      <div class="fullscreen-vid-wrap">
        <a href="Main.do"><video src="video/video2.mp4" autoplay loop muted></video></a>
      </div>
    </header>
    <section class="login-form">
      <h1>Login</h1>
      <form action="login.do" method="post">
        <div class = "int-area">
            <input type="text" name="email" id="email"
            autocomplete="off" required>
            <label for="email"> 이메일</label>    
        </div>
        <div class = "int-area">
          <input type="password" name="pwd" id="pwd"
          autocomplete="off" required>
          <label for="pwd"> 비밀번호</label>    
        </div>
        <div class="btn-login">
          <button id="btn" type="submit"> 로그인 </button>
        </div>
      </form>
      <div id="naver_id_login"></div>
      <div id="kakao_id_login"> <a id="custom-login-btn" href="javascript:loginWithKakao()">
      <img src="https://developers.kakao.com/tool/resource/static/img/button/login/simple/ko/kakao_login_medium.png"></a> </div>
      <div class = "signup">
      <span> 회원가입은 <a href="Signup.do">여기</a>를 눌러주세요</span>
      </div>
      <div class = "caption">
        <a href="EmailCheckForm.do">이메일찾기</a>&nbsp&nbsp&nbsp&nbsp&nbsp
        <a href="PwdCheckForm.do">비밀번호찾기</a>
      </div>
    </section>
  <script>
 
      let email =$('#email');
      let pwd =$('#pwd');
      let btn =$('#btn');

      $(btn).on('click', function(){
        if($(email).val() == ""){
            $(email).next('label').addClass('warning')
            setTimeout(function(){
              $('label').removeClass('warning');
            },1500);
        }
        else if($(pwd).val() == "") {
          $(pwd).next('label').addClass('warning')
          setTimeout(function(){
              $('label').removeClass('warning');
            },1500);
      }
    });
  </script>
    <script type="text/javascript">
    //네이버 api
    var naver_id_login = new naver_id_login("GEn5BsvETFtbptoXb3iD", "http://localhost:8090/project_JSP/naver.do");
    var state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 2,40);
    naver_id_login.setDomain("/project_JSP");
    naver_id_login.setState(state);
    naver_id_login.setPopup();
    naver_id_login.init_naver_id_login();
  </script>

<script type="text/javascript">
	//카카오api
	
	window.Kakao.init('ec2756af0fdc1f93414b818178f9770f');
 
	function loginWithKakao() {
    Kakao.Auth.login({
      success: function(authObj) {
        alert('나는야 개발자사이트에 오신걸 환영합니다')
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
</script>
  
</body>
</html>

