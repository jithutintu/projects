package com.niit.backend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.DAO.CategoryDaoimpl;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.ProductDaoimpl;
import com.niit.backend.DAO.SupplierDao;
import com.niit.backend.DAO.SupplierDaoimpl;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Supplier;


@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextConfig {		
	@Bean
		    public DataSource getH2DataSource() {
			 String url ="jdbc:h2:mem:test;"+
		    "INIT = CREATE SCHEMA IF NOT EXISTS TEST";
			 DriverManagerDataSource dataSource=new DriverManagerDataSource();
			 dataSource.setDriverClassName("org.h2.Driver");
		    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		    	dataSource.setUsername("sa");
		    	dataSource.setPassword("");
		    	return dataSource;
		    }
		    
		    private Properties getHibernateProperties() {
		    	Properties properties = new Properties();
		    	properties.put("hibernate.show_sql", "true");
		    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		    	properties.put("hibernate.hdbm2ddl.auto","update");
		    	return properties;
		    }
		    
		    @Autowired
		    @Bean(name = "sessionFactory")
		    public SessionFactory getSessionFactory(DataSource dataSource) {
		    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		    	sessionBuilder.addProperties(getHibernateProperties());
		    	sessionBuilder.addAnnotatedClasses(Category.class);
		    	sessionBuilder.addAnnotatedClasses(Supplier.class);
		    	sessionBuilder.addAnnotatedClasses(Product.class);
				return sessionBuilder.buildSessionFactory();
		    }
		 
			@Autowired
			@Bean(name = "transactionManager")
			public HibernateTransactionManager getTransactionManager(
					SessionFactory sessionFactory) {
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(
						sessionFactory);

				return transactionManager;
			}
				
			
		    @Autowired
		    @Bean(name = "categoryDAO")
		    public CategoryDao getCategoryDAO(SessionFactory sessionFactory) {
		    	return new CategoryDaoimpl(sessionFactory);
		    }

@Autowired
@Bean(name="supplierDAO")
public SupplierDao geTSupplierDAO(SessionFactory sessionFactory)
{
	return new SupplierDaoimpl(sessionFactory);
}
		
@Autowired
@Bean(name="productDAO")
public ProductDao getProductDAO(SessionFactory sessionFactory)
{
	return new ProductDaoimpl(sessionFactory);
}




	}