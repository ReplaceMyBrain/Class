package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentNoticedao;

public class NoticeCommentModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String nc_num =request.getParameter("nc_num");
		String nc_content = request.getParameter("nc_content");
		
		ContentNoticedao dao = new ContentNoticedao();
		String result = dao.commentModiey(nc_num, nc_content);
		
		request.setAttribute("result", result);
	}

}
