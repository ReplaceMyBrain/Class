package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentNoticedao;
import com.jspproject.bbs.dto.ContentNoticedto;

public class NoticeCommentContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String nc_num =request.getParameter("nc_num");
		
		ContentNoticedao dao = new ContentNoticedao();
		ContentNoticedto dto = dao.commentContent(nc_num);
		
		request.setAttribute("commentcontent_view", dto);
	}

}
