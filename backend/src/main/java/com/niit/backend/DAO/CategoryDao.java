package com.niit.backend.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.backend.model.Category;

@Repository
public interface CategoryDao {
	
	public boolean  save(Category category);
	public boolean update(Category category);
	public boolean delete (String id);

	public Category  get(String id);

	public List<Category>list();
}
