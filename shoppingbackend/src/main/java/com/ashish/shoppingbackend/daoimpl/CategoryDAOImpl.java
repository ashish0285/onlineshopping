package com.ashish.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ashish.shoppingbackend.dao.CategoryDAO;
import com.ashish.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static{
		
		categories.add(new Category(1,"Television","description for Television","Cat1.png"));
		categories.add(new Category(2,"Mobile","description for Mobile","Cat2.png"));
		categories.add(new Category(3,"Laptop","description for Laptop","Cat3.png"));
		categories.add(new Category(4,"Refrigerator","description for Refrigerator","Cat4.png"));
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//enhanced for loop
		for(Category category: categories){
			if(category.getId()== id) return category;
			
		}
		
		return null;
	}

}
