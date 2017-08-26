package com.ashish.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ashish.onlineshopping.util.FileUploadUtility;
import com.ashish.onlineshopping.validator.ProductValidator;
import com.ashish.shoppingbackend.dao.CategoryDAO;
import com.ashish.shoppingbackend.dao.ProductDAO;
import com.ashish.shoppingbackend.dto.Category;
import com.ashish.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		if(operation!=null){
			if (operation.equals("product")){
				mv.addObject("message", "Product Submitted Successfully");
			} else if (operation.equals("category")){
				mv.addObject("message", "Category Submitted Successfully");
			}
		}
		Product nProduct = new Product();
		// set values
		nProduct.setCategoryId(1);
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		return mv;
	}
	
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = productDAO.get(id);
		// set values
		
		mv.addObject("product", nProduct);

		return mv;
	}

	//handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result, Model model, HttpServletRequest request) {
		
		if(mProduct.getId()==0){
		//validate image if its a new product
			new ProductValidator().validate(mProduct, result);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				// user has selected some file
				new ProductValidator().validate(mProduct, result);
			}
		}
		
		if(result.hasErrors()){
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for Product Submission");
			
			return "page";
		}
		logger.info(mProduct.toString());
		
		if(mProduct.getId()==0){
		productDAO.add(mProduct);
		}else{
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	/*
	 * Manage Product Activation
	 * */
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String manageProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		 Boolean isActive = product.isActive();
		 product.setActive(!product.isActive());
		 productDAO.update(product);
		return isActive? "Succesfully Deactivated the Product Id: "+product.getId() :"Succesfully Activated the Product Id: "+product.getId();
	}
	
	/*
	 * handle category submission
	 * */
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String manageCategorySubmission(@ModelAttribute Category category) {
		
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}
	@ModelAttribute("category")
	public Category getCategory() {

		return new Category();
	}
	
	

}
