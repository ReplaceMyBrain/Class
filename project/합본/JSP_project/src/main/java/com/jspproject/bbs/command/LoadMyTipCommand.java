package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.MyPostDao;
import com.jspproject.bbs.dao.ProfileDao;
import com.jspproject.bbs.dto.PostDto;
import com.jspproject.bbs.dto.ProfileDto;



public class LoadMyTipCommand implements Command {

int numOfTuplesPerPage = 10;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String currentUser = "'" + (String)session.getAttribute("email") + "'";
		
		ProfileDao profileDao = new ProfileDao();
		ProfileDto dto = profileDao.loadProfile(currentUser);

		int requestPage = 1;
		MyPostDao listDao = new MyPostDao();
		session = request.getSession();

		if ( request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("courrentPage", requestPage);
		}

		int countedTuple = listDao.selectTip(currentUser);

		ArrayList<Integer> pageList = calcNumOfPage(countedTuple);
		session.setAttribute("pageList", pageList);
		session.setAttribute("do", "profileOnlyIdea.do");
		
		ArrayList<PostDto> dtos = listDao.myTipList(currentUser, requestPage, countedTuple);
		
		request.setAttribute("count", Integer.toString(countedTuple));
		request.setAttribute("myList", dtos);
		System.out.println(dtos);
		request.setAttribute("myprofile", dto);
	}
	
	public ArrayList<Integer> calcNumOfPage(int countedTuple) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int calcPage = 0;
		if (countedTuple % numOfTuplesPerPage == 0) {
			calcPage = countedTuple / numOfTuplesPerPage;
		} else {
			calcPage = countedTuple / numOfTuplesPerPage + 1;
		}
		for (int i = 1; i <= calcPage; i++) {
			System.out.println(i);
			arr.add(i);
		}
		return arr;
	}
}
