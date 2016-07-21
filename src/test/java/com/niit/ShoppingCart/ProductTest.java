package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		System.out.println("pro test");
		
	   ProductDAO productDAO = 	(ProductDAO) context.getBean("productDAO");
	   System.out.println("in pro test1");
	   
	   Product product = 	(Product) context.getBean("product");
	   System.out.println("in pro test2");
	   product.setId("Prd101");
	   System.out.println("in pro test3");
	   product.setName("iPhone");
	   System.out.println("in pro test4");
	   product.setPrice(50000);
	   System.out.println("in pro test5");
	   product.setDescription("Its designed by Apple");
	   System.out.println("in pro test 6");
	   
	   
	   productDAO.saveOrUpdate(product);
	   System.out.println("in pro test 7");
	   
//
//	   //This funciton will delete details from h2 db if "id" is given, as given below
//	   productDAO.delete("Sup121");
	   
	   
	   //This is list function, where it will return the list of records; to make it meaningful- i had returned size method. it has to be given as below shown..
	   System.out.println("No of Products "+ productDAO.list().size() );
	   
	 

	
	 /* if(   productDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Product does not exist");
	  }
	  else
	  {
		  System.out.println("Product exist .. the details are ..");
		  System.out.println();
	  }*/
	
		
		
	}

}
