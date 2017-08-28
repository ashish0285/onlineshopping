package com.ashish.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.shoppingbackend.dao.UserDAO;
import com.ashish.shoppingbackend.dto.Address;
import com.ashish.shoppingbackend.dto.Cart;
import com.ashish.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ashish.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*
	 * @Test public void addTest() {
	 * 
	 * user = new User(); user.setFirstName("Hritik");
	 * user.setLastName("Roshan"); user.setEmail("hr@gmail.com");
	 * user.setContactNumber("1234512345"); user.setPassword("123456");
	 * user.setRole("USER");
	 * 
	 * // add user assertEquals("User added Successfully", true,
	 * userDAO.addUser(user));
	 * 
	 * address = new Address(); address.setAddressLineOne("83/176 R.H.B");
	 * address.setAddressLineTwo("Pratap Nagar, Sanganer");
	 * address.setCity("Jaipur"); address.setState("Rajasthan");
	 * address.setPostalCode("302033"); address.setBilling(true);
	 * 
	 * // liking with user id address.setUserId(user.getId());
	 * 
	 * // add user assertEquals("Address added Successfully", true,
	 * userDAO.addAddress(address));
	 * 
	 * if(user.getRole().equals("USER")) {
	 * 
	 * // create a cart for this user cart = new Cart();
	 * 
	 * cart.setUser(user);
	 * 
	 * // add the cart assertEquals("Added Cart Successfully!",true,
	 * userDAO.addCart(cart));
	 * 
	 * 
	 * // add a shipping address for this user
	 * 
	 * address = new Address(); address.setAddressLineOne(
	 * "201/B Jadoo Society, Kishan Kanhaiya Nagar"); address.setAddressLineTwo(
	 * "Near Kudrat Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setPostalCode("400001"); // set
	 * shipping to true address.setShipping(true);
	 * 
	 * // link it with the user address.setUserId(user.getId());
	 * 
	 * // add the shipping address assertEquals(
	 * "shipping address added successfully!",true,
	 * userDAO.addAddress(address)); } }
	 */
	/*
	 * @Test public void addTest() {
	 * 
	 * user = new User(); user.setFirstName("Hritik");
	 * user.setLastName("Roshan"); user.setEmail("hr@gmail.com");
	 * user.setContactNumber("1234512345"); user.setPassword("123456");
	 * user.setRole("USER");
	 * 
	 * if(user.getRole().equals("USER")) {
	 * 
	 * // create a cart for this user cart = new Cart();
	 * 
	 * cart.setUser(user); user.setCart(cart); } // add user assertEquals(
	 * "User added Successfully", true, userDAO.addUser(user));
	 * 
	 * }
	 */
	/*
	 * @Test public void testUpdateCart() {
	 * 
	 * user=userDAO.getByEmail("hr@gmail.com"); cart=user.getCart();
	 * cart.setGrandTotal(5555); cart.setCartLines(2);
	 * 
	 * // add the shipping address assertEquals("Cart Updated successfully!"
	 * ,true, userDAO.updateCart(cart));
	 * 
	 * }
	 */
	/*@Test
	public void testAddAddress() {
		// add a user
		user = new User();
		user.setFirstName("Hritik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setPassword("123456");
		user.setRole("USER");

		// add user
		assertEquals("User added Successfully", true, userDAO.addUser(user));

		// add address

		address = new Address();
		address.setAddressLineOne("83/176 R.H.B");
		address.setAddressLineTwo("Pratap Nagar, Sanganer");
		address.setCity("Jaipur");
		address.setState("Rajasthan");
		address.setPostalCode("302033");
		address.setBilling(true);
		// attach user
		address.setUser(user);

		assertEquals("Address added Successfully", true, userDAO.addAddress(address));

		// add shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setPostalCode("400001");
		// setshipping to true
		address.setShipping(true);
		// attach user
		address.setUser(user);
		// add the shipping address
		assertEquals("Address added Successfully", true, userDAO.addAddress(address));

	}*/

	/*@Test
	public void testAddAddress() {
		//fetch a user
		
		user=userDAO.getByEmail("hr@gmail.com");
		
		// add address

		address = new Address();
		address.setAddressLineOne("83/174 R.H.B");
		address.setAddressLineTwo("Pratap Nagar, Sanganer");
		address.setCity("Jaipur");
		address.setState("Rajasthan");
		address.setPostalCode("302033");
		address.setShipping(true);
		// attach user
		address.setUser(user);

		assertEquals("Address added Successfully", true, userDAO.addAddress(address));
	}*/
	
	@Test
	public void testGetAddresses(){
		//fetch a user
		user=userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Successfully Fetched list of Address", 2, userDAO.listShippingAddresses(user).size());
		
		assertEquals("Successfully Fetched Billing Address", true, userDAO.getBillingAddress(user).getCity().equals("Jaipur"));
		
		
	}
	
}
