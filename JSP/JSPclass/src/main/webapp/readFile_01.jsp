<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //파일 불러오기 바뀌지 않는다 복붙해서 쓰면된다.
	BufferedReader reader = null;
	try{
		String filePath = application.getRealPath("file.txt"); 	// 위치 불러오기
		reader = new BufferedReader(new FileReader(filePath));		// 위치 사용해서 내용 불러오기
		while(true){
			String str = reader.readLine();
			if(str==null) break;
			out.print(str + "<br>");
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{								//체크 여기에서 try/catch는 들어간다. 
		try{
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

</body>
</html>