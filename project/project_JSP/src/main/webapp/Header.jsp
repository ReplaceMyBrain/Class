<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>headerLogin</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

*{
    margin: 0px;
    padding: 0px;
    list-style: none;
    text-decoration:none;
    color: black;
    font-family: 'Noto Sans KR', sans-serif;
  
}
.header{
    height: 180px;
    text-align: center;
    box-sizing: border-box;
    border-bottom: 1px solid #999;
}

.header_logo{
    display :flex;
    justify-content:space-around;
    align-items: center;
    padding-left :29vw;
    padding-top: 20px;

}
.header_logo h1{
    font: bold 40px 'arial';
    padding-top: 10px;
    letter-spacing: 2px;
}
.header_sublogo p{
    font: 15px 'arial';
    letter-spacing: 2px;
    margin-top: 3px;
}

.header_logo ul li{
    display: inline-block;
}
.header_logo ul li a{
    display: block;
    font-size: 20px;
    color : rgb(0, 0, 0);
    margin:  0px 5px
}    
.header_logo ul li a:hover{
    color: rgb(94, 103, 228);
    }

.menu ul{
    margin-top: 30px;
}
.menu ul li{
    display: inline-block;
}
.menu ul li a{
    display: block;
    font-size: 20px;
    color : rgb(0, 0, 0);
    margin:  0px 15vh
}
.menu ul li a:hover{
    color: rgb(94, 103, 228);
    }


</style>
<title>header</title>
</head>
<body>
    <header class="header">
       <div class="header_logo">
            
            <a href="" class="title"><h1>마음만은 TOP 개발자</h1></a>
            <ul>
            
            
            <% //세션값이 없으면 회원가입 표시 아닐경우 로그인으로 표시됨. 
            Object email = session.getAttribute("email");
            if(email == null) {%>
                <li><a href="Signup.do" class="Guest">회원가입</a></li>
                <li><a href="Home.do" class="Guest">로그인</a></li>
			<% }else {%>
                <li><a href="" class="login">마이페이지</a></li>
                <li><a href="Logout.do" class="login">로그아웃</a></li>
				
			<%}%> 
            </ul>
        </div>
        <div class="header_sublogo">
            <p>Developer Review Site</p>
        </div>
    <nav>
       <div class="menu">
            <ul>
                <li><a href="">개발자의 물건</a> </li>
                <li><a href="">개발자의 아이디어</a> </li>
                <li><a href="">공지사항</a> </li>
            </ul>
       </div>
     </nav>
        
    </header>
</body>
</html>