package com.ashish.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.shoppingbackend.dao.UserDAO;
import com.ashish.shoppingbackend.dto.Address;
import com.ashish.shoppingbackend.dto.Cart;
import com.ashish.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		try{
		String selectFromEmail="FROM User WHERE email=:email";
		Query query = sessionFactory.getCurrentSession().createQuery(selectFromEmail);
		query.setParameter("email", email);
		
		return (User) query.getSingleResult();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		try{
			String selectBillingAddress="FROM Address WHERE user=:user AND billing=:billing";
			Query query = sessionFactory.getCurrentSession().createQuery(selectBillingAddress);
			query.setParameter("user", user);
			query.setParameter("billing", true);
			return (Address) query.getSingleResult();
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		try{
			String selectShippingAddress="FROM Address WHERE user=:user AND shipping=:shipping";
			Query query = sessionFactory.getCurrentSession().createQuery(selectShippingAddress);
			query.setParameter("user", user);
			query.setParameter("shipping", true);
			return query.getResultList();
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}

}
