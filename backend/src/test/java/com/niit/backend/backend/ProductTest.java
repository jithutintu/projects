package com.niit.backend.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.ProductDao;
import com.niit.backend.model.Product;

public class ProductTest {
	public static void main( String[] args )
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		ProductDao productDao=(ProductDao) context.getBean("productdaoimpl");
	Product product = (Product) context.getBean("product");
	product .setId("PD3");
	product.setName("Iphone");
	product.setPrice("60000");
	product.setCategory_id("CN3");
	product.setSupplier_id("Sup2");
	productDao.update(product);	
	 System.out.println( "objects are created successfully");
	
}
}
