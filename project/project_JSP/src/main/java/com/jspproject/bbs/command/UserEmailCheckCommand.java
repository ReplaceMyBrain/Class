package com.jspproject.bbs.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jspproject.bbs.dao.SignupDao;

public class UserEmailCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		SignupDao dao = new SignupDao();
		
		boolean emailCheck = dao.emailCheck(email);
		
		request.setAttribute("email", emailCheck);
		
		PrintWriter out = ((ServletResponse) request).getWriter();
		if(emailCheck=true) {
			out.print(true);
		}else if(emailCheck=false) {
			out.print(false);
		}
			

	}


}
