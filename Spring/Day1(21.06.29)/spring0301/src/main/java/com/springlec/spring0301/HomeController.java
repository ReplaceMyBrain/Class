package com.springlec.spring0301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	//주소의 뒤에 불러오는거
	@RequestMapping("board/view")
	public String view() {
		return "board/view";
	}
	
	//값 보내는 법! 최근방식
	@RequestMapping("board/content")
	public String content(Model model) {
		model.addAttribute("id",30);
		return "board/content";
	}
	
	//옛날방식
	@RequestMapping("board/reply")
	public ModelAndView reply() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",30);
		modelAndView.setViewName("board/reply");
		return modelAndView;
		
	}
	
	
}
