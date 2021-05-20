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
	String address1 = request.getParameter("address1");
	String address2 = request.getParameter("address2");
	String github = request.getParameter("github");
	String address = (address1+ " " +address2);
	
	System.out.println(address);
	SignupDao dao = new SignupDao();
	dao.register(email, pw, name, tel, address, github);
	
	request.setAttribute("name", name);
	}
}
