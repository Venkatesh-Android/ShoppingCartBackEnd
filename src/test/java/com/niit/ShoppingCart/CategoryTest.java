package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		System.out.println("in test");
		
	   CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");
	   System.out.println("in test1");
	   
	   Category category = 	(Category) context.getBean("category");
	   System.out.println("in test2");
	   category.setId("CG120");
	   System.out.println("in test3");
	   category.setName("CGName120");
	   System.out.println("in test4");
	   category.setDescription("CGDesc120");
	   System.out.println("in test 5");
	   
	   
	   categoryDAO.saveOrUpdate(category);
	   System.out.println("in test 6");
	   
	   
	   
	
	  if(   categoryDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Category does not exist");
	  }
	  else
	  {
		  System.out.println("Category exist .. the details are ..");
		  System.out.println();
	  }
	
		
		
	}

}
