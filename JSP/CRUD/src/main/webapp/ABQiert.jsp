<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 명단 리스트</title>
</head>
<body>

 <% 
	String url_mysql = "jdbc:mysql://localhost/wtest?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
%>
  	<h2> 주소록 명단 리스트</h2><br>
	 <form action = "ABQuery.jsp">
	 	검색선택 : 		
	 	<select name="search">
			<option value="name"> 이름 </option>
			<option value="tel"> 전화번호 </option>
			<option value="address" selected ="selected"> 주소 </option>
			<option value="relation"> 관계 </option>
		</select>
	 	<input type="text"  name="searchText" size ="10">
	 	<input type="submit" value="검색">
	  
	</form>
			<table border="1">
				<tr>
					<th>seq</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>전자우편</th>
					<th>관계</th>
				</tr>
	
	
		
<% 	
		String search = request.getParameter("search");
		String searchText = request.getParameter("searchText");
		
		if(searchText == null){
			search = "name";
			searchText = "";
		}//첫화면 값이 null이니까 내가 처음에 정해주고 검색 되게 한다!!

	String A = "select seq,name,tel,address,email,relation from addressbook" 
	String B = "where" + search + "like '%" + searchText%
	int cnt=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
		
			ResultSet rs = stmt_mysql.executeQuery(A+B);
			while(rs.next()){ 
			%>
				<tr>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(5)%></td>
				</tr>
<% 				
				cnt++;
			}
%>			
			</table>
<% 			
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
%>
	<p>총인원은 <%=cnt %>명입니다</p>

			
</body>
</html>