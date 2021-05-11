<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보 수정</title>
</head>
<style>
	#userid {
	color: red;'
	font-size: 1px; 
	}
</style>

<body>
	<h4>수정 후 확인 버튼을 누르세요!</h4>
<% 

	String userid = request.getParameter("userid");

	String strUserid = null;
	String strName = null;
	String strTel = null;
	String strAddress = null;
	
	//------------
	String url_mysql = "jdbc:mysql://localhost/wtest?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	String whereStatemenet = "select userid,name,tel,address from purchaserinsert where userid = " + "\""+ userid + "\"";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
		
			ResultSet rs = stmt_mysql.executeQuery(whereStatemenet);
			while(rs.next()){
					strUserid = rs.getString(1);
					strName = rs.getString(2);
					strTel = rs.getString(3);
					strAddress = rs.getString(4);
			}
			
			conn_mysql.close();
			

			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
%>		


	<form action="purchaserUpdate_03.jsp" method="post">
		<table>
			<tr>
				 <td>사용자ID : </td>
				 <td> <input type="text" name="userid" size="10" value="<%=strUserid %>" readonly="readonly" ><span id="userid">수정불가능합니다</span> </td>
			</tr>
			<tr>
				 <td>성명 :</td>
				 <td> <input type="text" name="name" size="10"value="<%=strName %>"></td>	
			</tr>
			<tr>
				 <td>전화번호 : </td>
				 <td> <input type="text" name="tel" size="10"value="<%=strTel %>"></td>	
			</tr>
			<tr>
				 <td>주소 : </td>
				 <td> <input type="text" name="address" size="30"value="<%=strAddress %>"></td>	
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
	
	
</body>
</html>