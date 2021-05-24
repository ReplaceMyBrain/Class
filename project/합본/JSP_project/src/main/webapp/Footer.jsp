<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
 *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
 }   
 body{
     background: #fcfcfc;    
 }
 footer{
     background: #111;
     height: auto;
     width: 100vw;
     font-family:  "open sans";
     padding-top: 20px;
     color: #fff;
 }
 .footer_info{
     display: flex;
     align-items: center;
     justify-content: center;
     flex-direction: column;
    }
 .footer_info h2{
     font-size: 1.8rem;
     font-weight: 400;
     text-transform: capitalize;
     line-height: 3rem;
    }   
 .footer_info p{
    max-width: 600px;
    margin: 1px auto;
    line-height: 20px;
    font-size: 11px;
    color:  rgba(255, 255, 255, 0.39);
    }    
.foot_link{
    list-style: none;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 5px 0 5px 0;
}
.foot_link li{
    margin: 0 10px;
}
.foot_link a{
    text-decoration: none;
    color : #fff;
    font-size: 13px;
}
.foot_link a:hover{
    color: rgb(94, 103, 228);
    }
 


</style>
<title>footer</title>
</head>
<body>
    <footer>
        <div class="footer_info">
            <h2> 나는야 개발자 </h2>
            
            <ul class="foot_link">
                <li><a href="">1:1문의</a></li>
                <li>I</li>
                <li><a href="">기부</a></li>
                <li>I</li>
                <li><a href="TermsAndConditions.do" target='_blank'>이용약관</a></li>
                <li>I</li>
                <li><a href="PrivacyPolicy.do"  target='_blank'>개인정보취급방침</a></li>
           </ul>
            
            <p class="adress">상호 : 나는야개발자(주) <span style="margin:0 3px">|</span>  소재지 : 서울특별시 서초구 강남대로 279, 5층(서초동, 백향빌딩) 
            <br>사업자 등록번호 : 000-00-00000 <span style="margin:0 3px">|</span>  개인정보관리책임자 : 우연진영 
            <br> Tel : 0000-0000 <span style="margin:0 3px">|</span>  Fax : 000-000-0000  <span style="margin:0 3px">|</span>   Email : admin@imdev.com 
            <br>고객님은 저희 사이트에 매료되었으므로 매일 방문할것입니다
            <br>Copyright 나는야개발자 All Right Reserved</p>
            
        </div>
    </footer>
</body>
</html>