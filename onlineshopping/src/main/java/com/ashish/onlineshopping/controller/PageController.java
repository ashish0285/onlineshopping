package com.ashish.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

@RequestMapping(value={"/","home","index"})
public ModelAndView index(){
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting", "Hello from Spring MVC");
	return mv;
}
}
