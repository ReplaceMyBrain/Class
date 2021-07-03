package com.springlec.oneline.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.oneline.dao.Dao;

public class DeleteCommand implements Command {

	private Dao dao = null;
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String no =request.getParameter("no");
		
		dao.delete(no);
		
		
	}

}
