<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력결과</title>
</head>
<body>
	<h3>입력결과</h3>



<% 

String result = request.getParameter("result");

if(result.equals("success")){ %>
		<table>
			<tr>
				 <td>사용자ID : </td>
				 <td>${USERID } </td>	
			</tr>
			<tr>
				 <td>성명 :</td>
				 <td>${NAME }</td>	
			</tr>
			<tr>
				 <td>전화번호 : </td>
				 <td>${TEL }</td>	
			</tr>
			<tr>
				 <td>주소 : </td>
				 <td>${ADDRESS }</td>	
			</tr>
		</table>
<% } else if(result.equals("fail")) {%>
	"가입에 실패하였습니다."

<% }
	session.invalidate();
%>


</body>
</html>