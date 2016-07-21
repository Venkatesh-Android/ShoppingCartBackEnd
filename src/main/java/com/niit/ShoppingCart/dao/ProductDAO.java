package com.niit.ShoppingCart.dao;

import java.util.List;


import com.niit.ShoppingCart.model.Product;

public interface ProductDAO {



	public List<Product> list();

	public Product get(String id);
	
	public void saveOrUpdate(Product category);

	public void delete(String id);



}
