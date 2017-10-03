package com.ashish.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashish.onlineshopping.exception.ProductNotFoundException;
import com.ashish.shoppingbackend.dao.CategoryDAO;
import com.ashish.shoppingbackend.dao.ProductDAO;
import com.ashish.shoppingbackend.dto.Category;
import com.ashish.shoppingbackend.dto.Product;

@Controller
public class PageController {

	//setting up SLF4J logger
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside Page Controller home meathod - INFO");
		logger.debug("Inside Page Controller home meathod - DEBUG");
		
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id); 
		
		mv.addObject("title", category.getName());
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		// passing single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	/*
	 * Viewing a Single product
	 * */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		
		product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		//update the product view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//-------------
		
		
		mv.addObject("title", product.getName());
		mv.addObject(product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required=false) String error, @RequestParam(name="logout", required=false) String logout){
		ModelAndView mv=new ModelAndView("login");
		if (error!= null){
			mv.addObject("errorMessage", "Invalid Username and Password!!");
		}
		if (logout!= null){
			mv.addObject("logout", "User has successfully logged out!!");
		}
		mv.addObject("title", "Login");
		return mv;
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied(){
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "Access Denied to this URL");
		mv.addObject("errorDescription", "You do not have access to the page you have requested");
		mv.addObject("title", "Access Denied!!");
		
		return mv;
	}
	
	@RequestMapping(value="/shopping-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
}
