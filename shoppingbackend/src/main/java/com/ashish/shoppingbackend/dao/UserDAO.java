package com.ashish.shoppingbackend.dao;

import java.util.List;

import com.ashish.shoppingbackend.dto.Address;
import com.ashish.shoppingbackend.dto.Cart;
import com.ashish.shoppingbackend.dto.User;

public interface UserDAO {

	//add a user
	boolean addUser(User user);
	
	//fetch user
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	//add a cart
	boolean updateCart(Cart cart);
	
}
