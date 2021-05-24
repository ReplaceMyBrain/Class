<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>donate</title>
</head>		
<script>
	$(document).ready(function() {
		 alert('${amount}$ 기부되었습니다.');
	});	
</script> 
<style>

#donate {
	text-align: center;
	color: 333333;
	font-family: Georgia, Serif;
	font-size: 20px;
	margin:100px;

}

#button{
  background:#ff2d54;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}

#button:hover{
  background:#fff;
  color:#ff2d54;
}

#button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}

#total {
  color:#ff2d54;
}

</style>


<body>
<div id="donate">

  <div id="donate-black">
     <h1>Donate to Developers !</h1>
    <p>This web is—and always will be—free. Our mission is to provide users amazing experience and lots of information. Your donation directly helps the development of 나는야 개발자.</p>
  	<br><p id=total> Total: ${sumDonate }$</p>
  </div><br>
  
  
    <h2>Donation amount</h2>
    
    <div id="donate_box">
    
      <div id="donate-amount">
       <form action="DonateClick.do">
          <input autocomplete="off" type="radio" name="amount" id="amount5" value="5" checked="">
          <label for="amount5">$5</label>
        
          <input autocomplete="off" type="radio" name="amount" id="amount10" value="10">
          <label for="amount10">$10</label>
        
          <input autocomplete="off" type="radio" name="amount" id="amount15" value="15">
          <label for="amount15">$15</label>
        
          <input autocomplete="off" type="radio" name="amount" id="amount25" value="25">
          <label for="amount25">$25</label>
        
          <input autocomplete="off" type="radio" name="amount" id="amount50" value="50">
          <label for="amount50">$50</label><br><br>
        
           <input type="submit" id="button" value="Donate to our !">
        </form>
    </div>
  </div>

</div>

</body>
</html>
<%@include file ="Footer.jsp" %> 