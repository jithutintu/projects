package com.niit.backend.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.backend.model.Product;

@Repository
public interface ProductDao {
	
	public boolean save(Product product);
	public boolean update( Product product);
    public boolean delete (Product product);
public Product get (String id);
public List<Product> list();

}
