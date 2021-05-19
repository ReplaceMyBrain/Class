package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.LoginDao;
import com.jspproject.bbs.dao.SignupDao;

public class UserEmailCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		SignupDao dao = new SignupDao();
		
		response.getWriter().write(dao.emailCheck(email)+"");
		System.out.println(dao.emailCheck(email)+"");
		
	}

}
