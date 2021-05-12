package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;

public interface BCommand {

	public void execute(HttpServletRequest request, HttpServletRequest response);
}
