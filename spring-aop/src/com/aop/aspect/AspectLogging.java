package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

	// add related advices for logging
	
	// start with @Before advice
	// @Before("execution(public void getDatabaseConnection())")
	// @Before("execution(public void com.aop.dao.DAOLoyalty.getDatabaseConnection())")
	// @Before("execution(public void get*())")
	// @Before("execution(void get*())")
	// @Before("execution(* get*())")
	// @Before("execution(* get*(..))")
	@Before("execution(* com.aop.dao.*.*(..))")
	private void beforeGetDatabaseConnection() {
		System.out.println("@Before - " + getClass() + ": loging  execution @Before advice on method");

	}
	
	
	
}
