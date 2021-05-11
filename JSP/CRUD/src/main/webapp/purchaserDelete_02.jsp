<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보삭제</title>
</head>

<body>
	<h4>삭제할 고객정보를 확인 후 버튼을 누르세요!</h4>
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


	<form action="purchaserDelete_03.jsp" method="post">
		<table>
			<tr>
				 <td>사용자ID : </td>
				 <td> <input type="text" name="userid" size="10" value="<%=strUserid %>" readonly="readonly" ></td>
			</tr>
			<tr>
				 <td>성명 :</td>
				 <td> <input type="text" name="name" size="10"value="<%=strName %>"readonly="readonly"></td>	
			</tr>
			<tr>
				 <td>전화번호 : </td>
				 <td> <input type="text" name="tel" size="10"value="<%=strTel %>"readonly="readonly"></td>	
			</tr>
			<tr>
				 <td>주소 : </td>
				 <td> <input type="text" name="address" size="30"value="<%=strAddress %>"readonly="readonly"></td>	
			</tr>
		</table>
		<input type="submit" value="확인">
	</form>
	
	
</body>
</html>