package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Supplier;

@Repository("supplierdaoimpl")
public class SupplierDaoimpl implements SupplierDao {
@Autowired
private Supplier supplier;
@Autowired
private SessionFactory sessionFactory;

public SupplierDaoimpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
@Transactional
	public boolean update(Supplier supplier) {
		
	try {
		
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Supplier supplier) {
		
	try {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
		return false;
	}
	
	}

	public Supplier get(String id) {
		String hql = "from Supplier where id = '" + id +"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Supplier> list =query.list();
		
		if(list !=null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Supplier> list() {
		
		return null;
	}

}
