<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	/* search 수정 */
	.search {
    	position: relative;
    	text-align: center;
    	width: 900px;
    	margin: 0 auto;
    	font-family: Georgia, Serif;
		font-size: 30px;
	}
	
	input {
    	width: 100%;
    	border-radius: 20px;
    	border: 1px solid #bbb;
    	margin: 10px 0;
    	padding: 10px 12px;
    	font-family: fontAwesome;
	}
	
	.box {
    display: inline;
    width: auto;
    border-radius: 0;
    margin: auto;
    text-align: center;
    color: #bbb;
	}

	
	#columns{
		column-width:250px;
		column-gap: 15px;
		max-width: 1300px;
		margin: 50px auto;
		
		font-family: Georgia, Serif;
		font-size: 20px;
	}
	#columns figure{
		display: inline-block;
		/* border : 1px solid rgba(0,0,0,0.2); */
		margin:0;
		
		margin-bottom: 30px;
		/* box-shadow:10px 10px 5px rgba(2,2,2,0.2); */
	}
	
	#columns figure img{
		width: 100%;
		border-radius: 20px;
	}
	
	#columns figcaption {
		margin-left:20px;
	}
	
	figure:hover {
	opacity: 0.4;
	}
	
</style>

</head>
	<body>
		<div class="search">
    		<script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    		<input type="text" placeholder="&#xf002; search" >
    	</div>
    	
		<div id="columns">
			<c:forEach items="${list}" var="dto">
  			<figure>
  				<img src=${dto.tImg }>
  				<figcaption>
  				${dto.tTitle }
  				</figcaption>
			</figure>
			</c:forEach>
		</div>
</body>

</html>