package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.LoginDao;


public class UserLoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		// TODO Auto-generated method stub
		
		//email, pw 받음.
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//logindao에서 login 메소스 실행 > 그 값을 loginemail로 저장
		LoginDao dao = new LoginDao();
		String loginemail = dao.login(email,pwd);
		
		//세션에 email로 저장
		session.setAttribute("email", loginemail);
		
		//확인해봄.
		System.out.println(loginemail);

	}
}
