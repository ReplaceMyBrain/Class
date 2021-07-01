package com.springlec.oneline.command;

import org.springframework.ui.Model;

public interface Command {

	void execute(Model model);
}
