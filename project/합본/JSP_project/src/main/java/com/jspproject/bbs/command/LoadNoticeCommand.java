package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.NoticeDao;
import com.jspproject.bbs.dto.NoticeDto;


public class LoadNoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		NoticeDao dao = new NoticeDao();
		
		ArrayList<NoticeDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
	
}
