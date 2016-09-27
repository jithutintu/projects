package com.niit.backend.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.model.Category;

public class CategoryTest {

	 public static void main( String[] args )
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		CategoryDao categoryDao= (CategoryDao) context.getBean("categoryDaoimpl");
		Category category = (Category) context.getBean("category");	
		
		category.setId("CT11");
		category.setName("ASU");
		category.setDescription("This is ANOD");
		categoryDao.save(category);
		 System.out.println( "objects are created successfully");
	}
}

