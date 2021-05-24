package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;


public class CommentModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String ic_num =request.getParameter("ic_num");
		String ic_content = request.getParameter("ic_content");
		
		ContentItemdao dao = new ContentItemdao();
		String result = dao.commentModiey(ic_num, ic_content);
		
		request.setAttribute("result", result);
		
	}

}
