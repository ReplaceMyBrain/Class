package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jspproject.bbs.dao.SignupDao;

public class UserRegisterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	String email = request.getParameter("email");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	String github = request.getParameter("github");
	
	SignupDao dao = new SignupDao();
	dao.register(email, pw, name, tel, address, github);
	
	}
}
