package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.UserDAO;
import com.niit.ShoppingCart.model.User;

public class UserTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		System.out.println("usr test");
		
	   UserDAO userDAO = 	(UserDAO) context.getBean("userDAO");
	   System.out.println("in usr test1");
	   
	   User user = 	(User) context.getBean("user");
	   System.out.println("in usr test2");
	  
	   user.setId("user100");
	   System.out.println("in usr test3");
	   
	   user.setName("Venkatesh");
	   System.out.println("in usr test4");
	   
	   user.setPassword("Technology");
	   System.out.println("in usr test5");
	   
	   user.setMobile("8056717578");
	   System.out.println("in usr test6");
	   
	   user.setE_mail("venkateshprabhakaran@gmail.com");
	   System.out.println("in usr test7");
	   
	   user.setAddress("204/144, E.B.Colony, V.G.Rao Nagar, Ganapathy, Cbe-06");
	   System.out.println("in usr test8");
	   
	   
	   userDAO.saveOrUpdate(user);
	   System.out.println("in usr test9");
	   
//
//	   //This funciton will delete details from h2 db if "id" is given, as given below
//	   userDAO.delete("user121");
	   
	   
	   //This is list function, where it will return the list of records; to make it meaningful- i had returned size method. it has to be given as below shown..
	   System.out.println("No of Users "+ userDAO.list().size() );
	   
	 

	
	 /* if(   userDAO.get("sdfsf") ==null)
	  {
		  System.out.println("User does not exist");
	  }
	  else
	  {
		  System.out.println("User exist .. the details are ..");
		  System.out.println();
	  }*/
	
		
		
	}

}
