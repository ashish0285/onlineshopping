package com.ashish.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.ashish.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
 
	// dbms DEPENDENT
	private final static String DATABASE_URL ="jdbc:mysql://localhost:3306/onlineshopping";
	private final static String DATABASE_DRIVER ="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT ="org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME ="root";
	private final static String DATABASE_PASSWORD ="root#123";
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		
		//database connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	//session Factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.ashish.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}
 
	//All hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	//transaction manager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager =new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
}
