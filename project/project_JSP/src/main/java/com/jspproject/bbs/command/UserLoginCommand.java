package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.LoginDao;


public class UserLoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		LoginDao dao = new LoginDao();
		String loginemail = dao.login(email,pw);
		
		request.setAttribute("email", loginemail);
		
		System.out.println(loginemail);

	}
}
