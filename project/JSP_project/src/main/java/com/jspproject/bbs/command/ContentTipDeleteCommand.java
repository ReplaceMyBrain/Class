package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentTipdao;

public class ContentTipDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String t_num =request.getParameter("t_num");
		
		ContentTipdao dao = new ContentTipdao();
		String result = dao.contentDelete(t_num);
		request.setAttribute("result", result);
	}

}
