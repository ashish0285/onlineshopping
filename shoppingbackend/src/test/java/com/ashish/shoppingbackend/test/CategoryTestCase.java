package com.ashish.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.shoppingbackend.dao.CategoryDAO;
import com.ashish.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ashish.shoppingbackend");
		context.refresh();
		
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
	
		category = new Category();
		category.setName("Mobile");
		category.setDescription("description for Mobile");
		category.setImageURL("Cat2.png");
		
		assertEquals("Successfully Added Category inside table!!",true, categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory(){
	
		category = categoryDAO.get(1);
		
		
		assertEquals("Successfully get Category from table!!","Television", category.getName());
	
	}*/
	
	/*@Test
	public void testUpdateCategory(){
	
		category = categoryDAO.get(1);
		category.setName("TV");
		
		assertEquals("Successfully updated Category in table!!",true, categoryDAO.update(category));
	
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(1);
			
		assertEquals("Successfully deleted Category in table!!",true, categoryDAO.delete(category));
	
	}*/
	/*@Test
	public void testListCategory(){
		
					
		assertEquals("Successfully fetched the list of active Category from table!!",3, categoryDAO.list().size());
	
	}*/
	
	@Test
	public void testCRUDCategory(){
		
		//add case
		category = new Category();
		category.setName("Laptop");
		category.setDescription("description for Laptop");
		category.setImageURL("Cat1.png");
		
		assertEquals("Successfully Added Category inside table!!",true, categoryDAO.add(category));
		category = new Category();
		category.setName("Television");
		category.setDescription("description for Television");
		category.setImageURL("Cat2.png");
		
		assertEquals("Successfully Added Category inside table!!",true, categoryDAO.add(category));
		
		// fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("Successfully updated Category in table!!",true, categoryDAO.update(category));
		
		//deleting the category
		assertEquals("Successfully deleted Category in table!!",true, categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fetched the list of active Category from table!!",1, categoryDAO.list().size());
		
	}
}
