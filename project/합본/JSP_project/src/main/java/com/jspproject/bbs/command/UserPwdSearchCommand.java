package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.PwdSearchDao;

public class UserPwdSearchCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		PwdSearchDao dao =new PwdSearchDao();
		String searchPwd = dao.pwdSearch(email,tel);
		String searchDeletedate = dao.deleteSearch(email,tel);
		
		session.setAttribute("searchPwd", searchPwd);
		session.setAttribute("searchDeletedate", searchDeletedate);
		
		System.out.println(searchPwd);
		System.out.println(searchDeletedate);
		
	}

}
