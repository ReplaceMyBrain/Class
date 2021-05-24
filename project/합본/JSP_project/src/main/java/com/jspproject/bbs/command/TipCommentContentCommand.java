package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentTipdao;
import com.jspproject.bbs.dto.ContentTipdto;

public class TipCommentContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String tc_num =request.getParameter("tc_num");
		
		ContentTipdao dao = new ContentTipdao();
		ContentTipdto dto = dao.commentContent(tc_num);
		
		request.setAttribute("commentcontent_view", dto);
	}

}
