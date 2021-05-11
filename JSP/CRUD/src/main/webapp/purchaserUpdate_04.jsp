<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정결과</title>
</head>
<body>


	<h3>수정 결과</h3>
		
		<table>
			<tr>
				 <td>사용자ID : </td>
				 <td>${USERID } </td>	
			</tr>
			<tr>
				 <td>성명 :</td>
				 <td>${NEWNAME }</td>	
			</tr>
			<tr>
				 <td>전화번호 : </td>
				 <td>${NEWTEL }</td>	
			</tr>
			<tr>
				 <td>주소 : </td>
				 <td>${NEWADDRESS }</td>	
			</tr>
		</table>
	
	상기의 정보로 수정되었다. 감사합니다.
</body>
</html>