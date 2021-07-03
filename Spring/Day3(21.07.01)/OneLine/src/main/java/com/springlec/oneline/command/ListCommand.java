package com.springlec.oneline.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.oneline.dao.Dao;
import com.springlec.oneline.dto.Dto;

public class ListCommand implements Command {

	private Dao dao = null;
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		ArrayList<Dto> dtos = dao.list();
		model.addAttribute("list",dtos);
		
		
	}

}
