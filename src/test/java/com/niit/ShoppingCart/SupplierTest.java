package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;

public class SupplierTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		System.out.println("sup test");
		
	   SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
	   System.out.println("in sup test1");
	   
	   Supplier supplier = 	(Supplier) context.getBean("supplier");
	   System.out.println("in sup test2");
	   supplier.setId("Sup121");
	   System.out.println("in sup test3");
	   supplier.setName("SupName121");
	   System.out.println("in sup test4");
	   supplier.setAddress("Chennai");
	   System.out.println("in sup test 5");
	   
	   
	   supplierDAO.saveOrUpdate(supplier);
	   System.out.println("in sup test 6");
	   
//
//	   //This funciton will delete details from h2 db if "id" is given, as given below
//	   supplierDAO.delete("Sup121");
	   
	   
	   //This is list function, where it will return the list of records; to make it meaningful- i had returned size method. it has to be given as below shown..
	   System.out.println("No of Suppliers "+ supplierDAO.list().size() );
	   
	 

	
	 /* if(   supplierDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Supplier does not exist");
	  }
	  else
	  {
		  System.out.println("Supplier exist .. the details are ..");
		  System.out.println();
	  }*/
	
		
		
	}

}
