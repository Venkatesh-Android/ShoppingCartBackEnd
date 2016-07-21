package com.niit.ShoppingCart.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	

	@Autowired
	private SessionFactory sessionFactory;


	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
			
	}

	@Transactional
	public void delete(String id) {
		Product product = new Product();
		product.setId(id);
		sessionFactory.getCurrentSession().delete(product);
	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id=" + "'"+ id +"'";
		//  from product where id = '101'
		@SuppressWarnings("deprecation")
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
	
	


}
