<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="Header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<style>
	#columns{
		display: grid;
		column-gap: 0px;
		grid-template-columns: 1fr 1fr 1fr;
		
		font-family: Georgia, Serif;
		font-size: 50px;
	}
	#columns figure {
		margin:0;
		height: 700px;
		position: relative;
	}
	
	#columns figure img {
		width: 100%;
		object-fit: cover;
		height: 100%
	}
	
	#columns figcaption {
	color: #ffffff;
	position: absolute;
	left: 0; right: 0; top: 0; bottom: 0;
	z-index: 2;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-flow: column;
	background: rgba(55, 55, 55, 0.5);
	}
	
	figure:hover figcaption p {
	color: rgb(255, 214, 10);
	} 
</style>

<body>

<div id="columns">

	<div id="tool">
	<figure>
  	<img src="gunnar-sigurdarson-nzff_emVOfE-unsplash.jpg">
  	<a href="list.do">
  	<figcaption>
  	<p>Dev Tool</p>
  	</figcaption>
  	</a>
	</figure>
	</div>
  	
  	<div id="idea">
	<figure>
	<img src="junior-ferreira-7esRPTt38nI-unsplash.jpg">
	<a href="list2.do">
	<figcaption>
	<p>Idea</p>
	</figcaption>
	</a>
	</figure>
	</div>
	
	<div id="alert">
  	<figure>
	<img src="jason-rosewell-ASKeuOZqhYU-unsplash.jpg">
	<a href="list3.do">
	<figcaption>
	<p>Notice</p>
	</figcaption>
	</a>
	</figure>
	</div>
	
</div>
<%@include file ="Footer.jsp" %> 
</body>
</html>