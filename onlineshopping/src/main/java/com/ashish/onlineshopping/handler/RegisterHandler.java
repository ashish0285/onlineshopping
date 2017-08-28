package com.ashish.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.ashish.onlineshopping.model.RegisterModel;
import com.ashish.shoppingbackend.dao.UserDAO;
import com.ashish.shoppingbackend.dto.Address;
import com.ashish.shoppingbackend.dto.Cart;
import com.ashish.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}
	public String saveAll(RegisterModel registerModel){
		try{
		User user=registerModel.getUser();
		if(user.getRole().equals("USER")){
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userDAO.addUser(user);
		
		Address billing=registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		return "success";
		} catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}
	
	public String validateUser(User user, MessageContext error){
		String transitionValue="success";
		
		//confirm password validation
		if(!user.getPassword().equals(user.getConfirmPassword())){
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("password does not match the confrm password!")
					.build());
			transitionValue="failure";
		}
		
		//checking uniqueness of email
		
		if(userDAO.getByEmail(user.getEmail())!=null){
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("email address is already used!!")
					.build());
			transitionValue="failure";
		}
		
		return transitionValue;
	}
}
