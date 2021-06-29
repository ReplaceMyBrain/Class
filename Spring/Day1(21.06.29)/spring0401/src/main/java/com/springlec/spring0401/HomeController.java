package com.springlec.spring0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//데이터를 가져오고 보냄
	@RequestMapping("board/confirmId")
	 public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		
		 //받음
		 String id = httpServletRequest.getParameter("id");
		 String pw = httpServletRequest.getParameter("pw");
		 
		 //보냄
		 model.addAttribute("id", id);
		 model.addAttribute("pw", pw);
		 
		 return "board/resultId";
		 
	}
	
	@RequestMapping("board/checkId")
	public String checkid(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		
		 model.addAttribute("id", id);
		 model.addAttribute("pw", pw);
		 
		 return "board/resultId";
	}

	
}
