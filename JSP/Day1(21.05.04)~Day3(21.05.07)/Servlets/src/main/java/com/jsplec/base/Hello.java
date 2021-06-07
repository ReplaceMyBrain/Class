package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello") // 속임수 //가짜 글씨 만들기 //해킹 불가능// Servlet이 중요한 이유!
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Hello World");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer =response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>Hello world</h1>");
		writer.print("get방식이 호출되었습니다.");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer =response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>Hello world</h1>");
		writer.print("post방식이 호출되었습니다.");
		writer.print("</body>");
		writer.print("</html>");
	}

}
