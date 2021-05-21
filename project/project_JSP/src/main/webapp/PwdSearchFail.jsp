<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
	    alert('비밀번호 찾기 실패: 정보확인불가 비밀번호를 찾을 수 없습니다.');  
	});
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
    
    #pwsearch-box {
      position: relative;
      margin: 5% auto;
      width: 400px;
      height: 330px;
      background: #FFF;
      padding:20px 40px;
      box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.3);
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

    input[type="submit"] {
      margin-top: 10px;
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
  
    .home {
      margin-top: 10px;
      text-align: center;
      width: 100%;
      height: 32px;
      background: hsl(214, 100%, 47%);
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    .home:hover,
    .home:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    .home:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
 
</style>  

    <title>비밀번호찾기</title>
</head>
<body>
    <div id="pwsearch-box">
      <h1>비밀번호 찾기</h1> 
      <form action="PwdSearch.do">
        <span>이메일</span><br>
        <input type="text" name="email" id="email" placeholder="이메일을 입력해주세요." />
        <span>핸드폰번호</span><br>
        <input type="text"  name="tel" id="tel" placeholder="-없이 핸드폰번호를 입력해주세요." />
        <input type="submit" id="pwsearch" value="비밀번호 찾기" />
     </form>
     <a href="Home.do"><button class="home">로그인</button></a> 
   </div>  
</body>
</html> 