package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
