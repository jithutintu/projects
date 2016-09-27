package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Category;


@Repository
public class CategoryDaoimpl implements CategoryDao {
	@Autowired
	private Category category;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	 @Transactional
	public boolean save(Category category) {
	
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(HibernateException e)
		{
		e.printStackTrace();	
		return false;
		}
		
	}
	 @Transactional
	public boolean update(Category category) {
		
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(HibernateException e)
		{
		e.printStackTrace();	
		return false;
		}
		
	}
		
	 @Transactional
	public boolean delete(String id) {
		try
		{
		sessionFactory.getCurrentSession().delete(get(id));
		return true;
		}
		catch(HibernateException e)
		{
		e.printStackTrace();	
		return false;
		}
		
	}
   
   
	public Category get(String id) {
		//select * from Ctegory where id= 'id'
				String hql = "from Category where id = '" + id +"'";
				Query query =sessionFactory.getCurrentSession().createQuery(hql);
				
				List<Category> list =query.list();
				
				if(list !=null || list.isEmpty())
				{
					return null;
				}
				return list.get(0);
	}
    

	public List<Category> list() {
		String hql = "from * Category";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	
}
