package com.niit.ShoppingCart.dao;

import java.util.List;

import com.niit.ShoppingCart.model.Category;

public interface CategoryDAO {



	public List<Category> list();

	public Category get(String id);
	
	public void saveOrUpdate(Category category);

	public void delete(String id);



}
