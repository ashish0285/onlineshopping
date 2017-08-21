package com.ashish.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.shoppingbackend.dao.ProductDAO;
import com.ashish.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ashish.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testCRUDCategory() {

		// add case
		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setActive(true);
		product.setDescription("description for Oppo Mobile phone S53");
		product.setUnitPrice(15000);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Successfully Added Product inside table!!", true, productDAO.add(product));

		// fetching and updating the category
		product = productDAO.get(2);
		product.setName("Samsung S7");
		product.setUnitPrice(20000);
		product.setActive(true);

		assertEquals("Successfully updated Product in table!!", true, productDAO.update(product));

		// deleting the category
		assertEquals("Successfully deleted Product in table!!", true, productDAO.delete(product));

		// fetching the list
		assertEquals("Successfully fetched the list of Product from table!!", 6, productDAO.list().size());

		// fetching the list
		assertEquals("Successfully fetched the list of active Product from table!!", 5,
				productDAO.listActiveProducts().size());

		// fetching the list
		assertEquals("Successfully fetched the list of active Product by Category from table!!", 3,
				productDAO.listActiveProductsByCategory(3).size());
	}

}
