package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Product;
import com.niit.backend.model.Supplier;

@Repository("productdaoimpl")
public class ProductDaoimpl implements ProductDao {
	@Autowired
	
	private Product product;
	
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoimpl (SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Product product) {
		
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String id) {
		String hql = "from Product where id = '" + id +"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Product> list =query.list();
		
		if(list !=null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Product> list() {
		
		return null;
	}
	
}
