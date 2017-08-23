package com.ashish.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(){
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "This Page is not Constructed!!!");
		mv.addObject("errorDescription", "This Page you are looking for is not available now!!!");
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException(){
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product Not Available!!!");
		mv.addObject("errorDescription", "This Product you are looking for is not available right now!!!");
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator!!!");
		mv.addObject("errorDescription", "Error!!! :" + e.toString());
		mv.addObject("title", "Error");
		
		return mv;
	}
	
}
