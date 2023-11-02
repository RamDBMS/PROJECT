package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class IndexController {                     //controller
	
	@RequestMapping("index")
	
	public ModelAndView  index(UserDetails ud)
	{
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("details", ud);              //model object

		mav.setViewName("index");                  //view
		
		
		
		
		return mav;
	}

}
