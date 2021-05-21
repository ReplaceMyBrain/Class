<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
</head>
<body>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("GEn5BsvETFtbptoXb3iD", "http://localhost:8090/project_JSP/naver.do");
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    alert('나는야 개발자사이트에 오신걸 환영합니다');
    close();
  }
  
 // 접근 토근삭제 
 // https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=GEn5BsvETFtbptoXb3iD&client_secret=UUtUpXX54z&access_token=AAAAPOdOnfQ3WTg87AySLqKDIwBHTHY7zRGKEK6pUG4liF9LH3A3uC047ttJJ12HOwsnNBTFbH9mX4ajDWd4Dpf9mmk&service_provider=NAVER
</script>
</body>
</html>
