package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.PwSearchDao;

public class UserPwSearchCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		PwSearchDao dao =new PwSearchDao();
		String searchPw = dao.pwSearch(email,tel);
		
		session.setAttribute("searchPw", searchPw);
		System.out.println(searchPw);
		
	}

}
