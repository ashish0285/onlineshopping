package com.ashish.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.shoppingbackend.dao.ProductDAO;
import com.ashish.shoppingbackend.dto.Category;
import com.ashish.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * Single Product by Product Id 
	 */
	@Override
	public Product get(int productId) {
		try {
			// trying to add Category to the database table
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * List of All Products
	 * */

	@Override
	public List<Product> list() {
		try {

			return sessionFactory.getCurrentSession().createQuery("FROM Product").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Adding a product
	 * */
	@Override
	public boolean add(Product product) {
		try {
			// trying to add Category to the database table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * updating a product
	 * */
	@Override
	public boolean update(Product product) {
		try {
			// trying to add Category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * deleting a product
	 * */
	@Override
	public boolean delete(Product product) {
		try {

			// trying to soft Category to the database table
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * List of Active Products
	 * */
	@Override
	public List<Product> listActiveProducts() {
		try{
		String selectActiveProducts="FROM Product WHERE active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
		query.setParameter("active", true);
		return query.getResultList();
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
 
	/*
	 * List of Active Products by Category
	 * */
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		try{
			String selectActiveProductsByCategory="FROM Product WHERE active=:active AND categoryId=:categoryId";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory);
			query.setParameter("active", true);
			query.setParameter("categoryId", categoryId);
			return query.getResultList();
			} catch (Exception e){
				e.printStackTrace();
				return null;
			}
	}

	/*
	 * Latest n active products
	 * */
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		try{
			String selectActiveProducts="FROM Product WHERE active=:active ORDER BY id";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
			query.setParameter("active", true);
			query.setFirstResult(0);
			query.setMaxResults(count);
			return query.getResultList();
			} catch (Exception e){
				e.printStackTrace();
				return null;
			}
	}

}
