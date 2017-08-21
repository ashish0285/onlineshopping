package com.ashish.shoppingbackend.dao;

import java.util.List;

import com.ashish.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
    Category get(int id);
}
