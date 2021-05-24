package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ItemsDao;
import com.jspproject.bbs.dto.PostDto;


public class LoadItemsCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		ItemsDao dao = new ItemsDao();
		
		ArrayList<PostDto> dtos = dao.list();
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "ITEM");
		session.setAttribute("CONDITION", "I_TITLE");
	}
}
