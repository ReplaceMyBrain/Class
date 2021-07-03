package com.springlec.oneline.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.oneline.command.Command;
import com.springlec.oneline.util.Constant;

@org.springframework.stereotype.Controller
public class Controller {
	
	private Command listCommand = null;
	private Command writeCommand = null;
	private Command deleteCommand = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	public void auto(Command list, Command write, Command delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		deleteCommand.execute(model);
	
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		return "write_view";	
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		writeCommand.execute(model);
	
		return "redirect:list";
	}
	
}
