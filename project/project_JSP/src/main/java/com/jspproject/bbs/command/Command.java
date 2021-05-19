package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface Command {
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException;
}

