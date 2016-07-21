package com.niit.ShoppingCart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.CategoryDAOImpl;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;

@Configuration
@ComponentScan("com.niit.ShoppingCart")
@EnableTransactionManagement


public class ApplicationContextConfig {
	

	
 	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		System.out.println("its is getting into dataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("in test88");
		dataSource.setDriverClassName("org.h2.Driver");
		System.out.println("in test99");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		System.out.println("in test00");

		dataSource.setUsername("sa");
		System.out.println("in test tt");
		dataSource.setPassword("password");
		System.out.println("in test nn");
		return dataSource;
	}
    
   
    
    private Properties getHibernateProperties() {
    	System.out.println("in test er");
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	System.out.println("in test ft");
     	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
     	System.out.println("in test ff");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClass(Category.class);
    	sessionBuilder.addAnnotatedClass(Supplier.class);
    	sessionBuilder.addAnnotatedClass(Product.class);
      	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
   


	
	
	  @Autowired
	    @Bean(name = "categoryDao")
	    public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
	    	return new CategoryDAOImpl(sessionFactory);
	    }
	
	
	
	

}
