package com.niit.backend.backend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.model.Category;

public class CategoryTestcase {

	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Autowired
	CategoryDao categoryDaoimpl;
	@Autowired
	Category category;
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDaoimpl=(CategoryDao) context.getBean("categoryDaoimpl");
		
	}
	
@Test
public void createCategoryTestCase()
{
	category.setId("CT10");
	category.setName("HP");
	category.setDescription("This is Laptop");
	Assert.assertEquals("Create Category",true,categoryDaoimpl.save(category));
}
@Test
public void updateCategoryTestCase()
{
	category.setId("CN4");
	category.setName("MI");
	category.setDescription("This iS moBILE");
	Assert.assertEquals(true,categoryDaoimpl.update(category));
}
@Test
public void deleteCategoryTestCase()
{
	Assert.assertEquals("delete Category",true,categoryDaoimpl.delete("CT10"));
	
}
@Test
public void getCategoryTestCase()
{
	Assert.assertEquals(true, categoryDaoimpl.get("CT10"));
}
@Test
public void listCategoryTestCase()
{
	Assert.assertEquals("List Category",5,categoryDaoimpl.list().size());
}
}