package com.spring.base0501;

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
import org.springframework.web.servlet.ModelAndView;

import com.spring.base0501.HomeController;

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
	
	
	@RequestMapping("index")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "student")
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("id" + id);
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "student")
	public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
		System.out.println("RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("id" + id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/studentId");
		mv.addObject("studentId",id);
		
		
		return mv;
	}
	
	@RequestMapping("studentGet")
	   public String goStudentGet(HttpServletRequest httpServletRequest, Model model) {
	      System.out.print("RequestMethod.GET");
	      String id = httpServletRequest.getParameter("id");
	      System.out.println("id"+id);
	      model.addAttribute("studentId", id);
	      
	      return "student/studentId";
	   }
	
	@RequestMapping("studentPost")
	public String goStudentPost(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("id" + id);
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	
	
}
