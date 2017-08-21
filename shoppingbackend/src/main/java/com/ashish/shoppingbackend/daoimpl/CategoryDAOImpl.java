package com.ashish.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.shoppingbackend.dao.CategoryDAO;
import com.ashish.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	/* private static List<Category> categories = new ArrayList<>();
	 static{
	
	 categories.add(new Category(1,"Television","description for
	 Television","Cat1.png"));
	 categories.add(new Category(2,"Mobile","description for
	 Mobile","Cat2.png"));
	 categories.add(new Category(3,"Laptop","description for
	 Laptop","Cat3.png"));
	 categories.add(new Category(4,"Refrigerator","description for
	 Refrigerator","Cat4.png"));
	
	 }*/

	@Override
	public List<Category> list() {
		// HQL From Entity name (and not Table name) and members
		
		try {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/*
	*Getting Single Category based on id
	*/
	@Override
	public Category get(int id) {
		
		try {
			// trying to add Category to the database table
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean add(Category category) {
		try {
			// trying to add Category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * Updating a single category
	 * */
	@Override
	public boolean update(Category category) {
		try {
			// trying to add Category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * Soft Delete
	 * */
	@Override
	public boolean delete(Category category) {
		try {
			
			// trying to soft Category to the database table
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
