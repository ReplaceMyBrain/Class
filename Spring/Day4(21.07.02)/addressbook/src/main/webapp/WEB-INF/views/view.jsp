<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post">
		<table>
			<tr>
				<td>번호</td>
				<td><input type="text" name="aId" value="${view.aId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="aName" size="20" value="${view.aName}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="aContent" size="50" value="${view.aContent}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="aAddress" size="50" value="${view.aAddress}"></td>
			</tr>
			<tr>
				<td>전자우편</td>
				<td><input type="text" name="aEmail" size="50" value="${view.aEmail}"></td>
			</tr>
			<tr>
				<td>관계</td>
				<td><input type="text" name="aRelation" size="50" value="${view.aRelation}"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="delete?aId=${view.aId}">삭제</a></td>
			</tr>
		</table>
	</form>
	

</body>
</html>