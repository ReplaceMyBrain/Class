package com.jspproject.bbs.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspproject.bbs.dao.SignupDao;

/**
 * Servlet implementation class UserRegisterCheckServlet
 */
@WebServlet("/UserRegisterCheckServlet")
public class UserRegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String email = request.getParameter("email");
		
		SignupDao dao = new SignupDao();
		
		String emailCheck = dao.emailCheck(email);
		System.out.println(emailCheck);
		
		if(email.equals(emailCheck)) {
		response.getWriter().write("false");
		}else {
		response.getWriter().write("true");
		}
	}
}
