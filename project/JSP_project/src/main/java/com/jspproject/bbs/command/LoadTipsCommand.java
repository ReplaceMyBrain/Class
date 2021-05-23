package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.TipsDao;
import com.jspproject.bbs.dto.PostDto;


public class LoadTipsCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		TipsDao dao = new TipsDao();
		
		ArrayList<PostDto> dtos = dao.list();
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "TIP");
		session.setAttribute("TITLE", "T_TITLE");
	}
}
