package com.springlec.addressbook.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.addressbook.dao.IDao;

public class Listcommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		
	}

}
