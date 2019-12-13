package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

	
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	private void pointcutPackageFunction() {};
	
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	private void pointcutGetterFunction() {};
	
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	private void pointcutSetterFunction() {};
	
	@Pointcut("pointcutPackageFunction() && !(pointcutGetterFunction() || pointcutSetterFunction())")
	private void pointcutPackageNotGetterNotSetterFunction() {};
	
	
	// start with @Before advice
	// @Before("execution(public void getDatabaseConnection())")
	// @Before("execution(public void com.aop.dao.DAOLoyalty.getDatabaseConnection())")
	// @Before("execution(public void get*())")
	// @Before("execution(void get*())")
	// @Before("execution(* get*())")
	// @Before("execution(* get*(..))")
	@Before("pointcutPackageFunction()")
	private void beforeGetDatabaseConnection() {
		System.out.println("@Before - " + getClass() + ": loging  execution @Before advice on method");
	}

	@Before("pointcutPackageFunction()")
	public void monitorApi() {
		System.out.println("@Before - " + getClass() + ": Monitor API execution @Before advice on method");
	}
	
	
	@Before("pointcutPackageNotGetterNotSetterFunction()")
	public void monitorApiNotGetter() {
		System.out.println("@Before - " + getClass() + ": Monitor API Not Getter execution @Before advice on method");
	}
	
	
}
