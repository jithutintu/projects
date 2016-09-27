package com.niit.backend.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.SupplierDao;
import com.niit.backend.model.Supplier;

public class SupplierTest {
	
	
	public static void main( String[] args )
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		SupplierDao supplierdao = (SupplierDao) context.getBean("supplierdaoimpl");
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setId("Sup2");
		supplier.setName("parbin");
		supplier.setAddress("Bangalore");
		supplierdao.save(supplier);
		
		System.out.println( "objects are created successfully");
	}
}
