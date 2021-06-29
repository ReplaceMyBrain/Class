package com.springlec.spring0302;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")

public class myController {

	@RequestMapping("/view1")
	public String view1() {
		return "test/view1";
	}
}
