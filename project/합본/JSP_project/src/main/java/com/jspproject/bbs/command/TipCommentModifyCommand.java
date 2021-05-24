package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentTipdao;

public class TipCommentModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String tc_num =request.getParameter("tc_num");
		String tc_content = request.getParameter("tc_content");
		
		ContentTipdao dao = new ContentTipdao();
		String result = dao.commentModiey(tc_num, tc_content);
		
		request.setAttribute("result", result);
	}

}
