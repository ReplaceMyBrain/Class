package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentNoticedao;

public class ContentNoticeDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String n_num =request.getParameter("n_num");
		ContentNoticedao dao = new ContentNoticedao();
		String result = dao.contentDelete(n_num);
		request.setAttribute("result", result);
	}

}
