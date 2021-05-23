package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.EmailSearchDao;



public class UserEmailSearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		EmailSearchDao dao =new EmailSearchDao();
		
		String searchEmail = dao.emailSearch(name,tel);
		String searchDeletedate = dao.deleteSearch(name,tel);
		
		session.setAttribute("searchEmail", searchEmail);
		session.setAttribute("searchDeletedate", searchDeletedate);

	}

}
