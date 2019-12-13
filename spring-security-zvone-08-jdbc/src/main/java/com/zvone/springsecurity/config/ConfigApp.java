package com.zvone.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.zvone.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class ConfigApp {
	
	// set up variable to hold the properties
	
	@Autowired
	private Environment theEnvironment;
	
	// set up a logger 
	
	private Logger theLogger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver ();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define a bean for our security datasource
	
	@Bean
	public DataSource theSecurityDataSource() {
		
		
		// create connection pool
		ComboPooledDataSource theSecurityDataSource = new ComboPooledDataSource();
		
		// set the jdbc driver
		
		try {
			theSecurityDataSource.setDriverClass(theEnvironment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException theExc) {
			// TODO Auto-generated catch block
			throw new RuntimeException(theExc);
		}
		
		// log the conecction props
		theLogger.info("ZVONE - jdbc.url = " + theEnvironment.getProperty("jdbc.url"));
		theLogger.info("ZVONE - jdbc.user = " + theEnvironment.getProperty("jdbc.user"));
		
		
		// set database connection from props file

		theSecurityDataSource.setJdbcUrl(theEnvironment.getProperty("jdbc.url"));
		theSecurityDataSource.setUser(theEnvironment.getProperty("jdbc.user"));
		theSecurityDataSource.setPassword(theEnvironment.getProperty("jdbc.password"));
		
		// set conection pool props		

		theSecurityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		theSecurityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		theSecurityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		theSecurityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return theSecurityDataSource;
		
	}
	
	
	// need a helper method 
	// read env prop and convert to int
	
	private int getIntProperty(String propName) {
		String propVal = theEnvironment.getProperty(propName);
		
		//converte string to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	

}
