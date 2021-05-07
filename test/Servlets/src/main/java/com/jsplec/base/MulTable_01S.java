package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulTavle_01
 */
@WebServlet("/MulTable_01S")
public class MulTable_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MulTable_01S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num1= Integer.parseInt( request.getParameter("num1"));  
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer =response.getWriter();
		writer.print("<html>");
		writer.println("<head><title>"+num1+"단-결과화면</title></head>");	
		writer.print("<body>");
		for(int i= 1; i<=9; i++) {
			writer.print(num1 + " X " + i + "=" + (num1 * i)+"<br>");
		}
		writer.print("</body>");
		writer.print("</html>");
		
		
			
			
		
		
	}

}
