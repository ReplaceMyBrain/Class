package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DecAdd
 */
@WebServlet("/DecAdd")
public class DecAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("<head><title>선언부를 이용한 덧셈</title></head>");		
		out.println("<body>");
		out.println("2+1=" + decAdd(2,1) + "<br>");		
		out.println("3+1=" + decAdd(3,1) + "<br>");		
		out.println("4+1=" + decAdd(4,1) + "<br>");		
		out.println("5+1=" + decAdd(5,1) + "<br>");		
		out.println("</body>");
		out.println("</html>");
		
	}

	private int decAdd(int num1, int num2) {
		int result =0;
		result =num1+num2;
		return result;
		
		
	}
	
	
}
