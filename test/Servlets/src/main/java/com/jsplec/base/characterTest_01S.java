package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class characterTest_01S
 */
@WebServlet("/characterTest_01S")
public class characterTest_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public characterTest_01S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name"); 
		String color = request.getParameter("color"); 
		String animal = request.getParameter("animal"); 
		String[] food = request.getParameterValues("food"); 
		
	
		PrintWriter writer =response.getWriter();
		writer.print("<html>");
		writer.println("<head><title>"+ name +"님의성격테스트</title></head>");	
		writer.print("<body>");
		writer.print("<h1> 성격테스트 </h1><br><br>");
		writer.print(name + "님의 성격 테스트 결과<br><br>");
		writer.print(color+"을 좋아하는 당신은" + animal + "그리고");
		
		for(int i=0; i<food.length; i++){
			if(i<food.length-1) {
					writer.print(food[i] + "과");
			}
			if(i==food.length-1)	{
				writer.print(food[i] +"을 좋아하는 성격입니다.");
			}
		}
	
		writer.print("</body>");
		writer.print("</html>");
		
		
		
	}
}