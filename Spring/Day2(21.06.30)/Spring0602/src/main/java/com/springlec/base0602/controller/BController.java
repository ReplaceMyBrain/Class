package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BModifyCommand;
import com.springlec.base0602.command.BWriteCommand;

@Controller
public class BController {
	
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand modifyCommand = null;
	private BCommand deleteCommand = null;
	
	
	
	

	@Autowired
	public void auto(BCommand list, BCommand write, BCommand content, BCommand modify, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.modifyCommand = modify;
		this.deleteCommand = delete;
	}

	
	

	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view");
		return "write_view";	
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		writeCommand.execute(model);
	
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contentCommand.execute(model);
		return "content_view";	
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
	
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		modifyCommand.execute(model);
	
		return "content_view";
	}
	
	
	
	
	
	
	
	
	
	
	
}
