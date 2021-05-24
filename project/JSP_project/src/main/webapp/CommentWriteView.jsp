<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 결과</title>
</head>
<script type="text/javascript">
function fail() {
	alert("댓글입력에 문제가 발생했습니다.");
	window.close();
}
function succ() {
	window.opener.location.reload();
	alert("댓글이 입력되었습니다.");
	window.close();
}
</script>
<body>
	<c:set var="result" value="${result}"/><!-- 변수선언 -->
	<c:choose>
		<c:when test="${result eq 'true'}"><%-- ${result == 'true'} --%>
			<script type="text/javascript">succ();</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">fail();</script>
		</c:otherwise>
	</c:choose>
</body>
</html>