package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentTipdao;

public class TipCommentWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String t_num = request.getParameter("t_num");
		
		/* 
	 	-----------------------------
	 	21.05.21 seungyeon
	 	****현재 userEmail 변수 선언해서 진행중
	 	-> 추후 세션으로 받아와서 바꿀 것.
	 	-----------------------------
		 */
		
//		String myEmail = (String) session.getAttribute("email");
		String myEmail = "aaa@naver.com";
		String tc_content = request.getParameter("tc_content");
		ContentTipdao dao = new ContentTipdao();
		String result = dao.commentWrite(t_num, myEmail, tc_content);

		request.setAttribute("result", result);
	}

}
