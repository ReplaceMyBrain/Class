<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
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
   /* body::before{
    content: "";
    position: absolute; z-index: 1;
    top: 0; right: 0; bottom: 0; left: 0;
    background-color: rgba(0, 0, 0, .3);
  }  */
  
  .login-form {
    position: absolute; z-index: index 1;;
    margin-left: 75%;
    margin-top: 10%;
    /*transform: translate(-50%,-50%);*/
    background: linear-gradient(rgba(204, 204, 204, 0.3),rgba(71, 71, 71, 0.3));
    width: 350px;
    padding:50px 30px;
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
  /*
  .int-area label.warning {
    color: red !important;
    animation: warning .3s ease;
    animation-iteration-count: 3;
  }

  @keyframes warning {
     0% {transform: translateX(-8px);}
     25% {transform: translateX(8px);}
     50% {transform: translateX(-8px);}
     75% {transform: translateX(8px);}
  }
  */

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
  }
  .btn-social{margin-top:  10px;
  }
  .btn-social button{
    width: 50%; height: 20px;
    background: #fff;
    color: rgb(0, 0, 0);
    font-size: 15px;
    border: none;
    border-radius: 10px;
  }
  .btn-social button.naver{
    background: #00ff37c2;
    color: rgba(0, 0, 0);
  }
  .btn-social button.kakao{
    background: #fbff00b4;
    color: rgba(0, 0, 0);
  }
  .signup{
      margin-top: 15px;
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
  .caption-guest {
    text-align: center;}
  .caption-guest a {
    font-size: 15px; color:rgb(182, 179, 179);
    text-decoration: none;
    
  }

 </style>
 <!--
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
  
     let email =$('#email');
     let pw =$('#pw');
     let btn =$('#btn-login');

      $(btn).on('click', function(){
        if($(email).val() ==""){
            $(email).next('label').addClass('warning')
            setTimeout(function(){
              $('lavel').removeClass('warning');
            },1500);
        }
        else if($(pw).val() == "") {
          $(pw).next('label').addClass('warning')
          setTimeout(function(){
              $('lavel').removeClass('warning');
            },1500);
      }
    });

  </script>
  
-->
  <title>나는야개발자</title>
</head>
<body>

    <header class="vid-header container">
      <div class="fullscreen-vid-wrap">
        <video src="video/video2.mp4" autoplay loop muted ></video>
      </div>
    </header>
    <section class="login-form">
      <h1>Login</h1>
      <form action="">
        <div class = "int-area">
            <input type="text" name="email" id="email"
            autocomplete="off" required>
            <label for = "email"> 이메일</label>    
        </div>
        <div class = "int-area">
          <input type="password" name="pw" id="pw"
          autocomplete="off" required>
          <label for = "pw"> 비밀번호</label>    
        </div>
        <div class="btn-login">
          <button type="submit" id="btn-login"> 로그인 </button>
        </div>
      </form>
        <div class="btn-social"> 
          <a href=""><button class="naver">NAVER</button></a><a href=""><button class="kakao">KaKao</button></a> 
       </div>
      <div class="caption-guest">
        <a href="HaederGuset.jsp">게스트로 입장하기</a>   
      </div>
      <div class = "signup">
      <span> 회원가입은 <a href="Signup.jsp">여기</a>를 눌러주세요</span>
      </div>
      <div class = "caption">
        <a href="EmailSearch.jsp">이메일찾기</a>&nbsp&nbsp&nbsp&nbsp&nbsp
        <a href="PwSearch.jsp">비밀번호찾기</a>
      </div>
    </section>

</body>
</html>

