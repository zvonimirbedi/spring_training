package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.Subscription;

@Aspect
@Component
@Order(2)
public class AspectLogging {	
	
	// start with @Before advice
	// @Before("execution(public void getDatabaseConnection())")
	// @Before("execution(public void com.aop.dao.DAOLoyalty.getDatabaseConnection())")
	// @Before("execution(public void get*())")
	// @Before("execution(void get*())")
	// @Before("execution(* get*())")
	// @Before("execution(* get*(..))")
/*	@Before("com.aop.aspect.PointcutUtility.pointcutPackageFunction()")
	private void beforeGetDatabaseConnection() {
		System.out.println("@Before - " + getClass() + ": loging  execution @Before advice on method");
	}*/
	@Before("com.aop.aspect.PointcutUtility.pointcutPackageFunction()")
	private void beforeGetDatabaseConnection(JoinPoint theJoinPoint) {		
		//Class name 
		System.out.println("@Before - " + getClass() + ": loging  execution @Before advice on method");
		
		//Method name 
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theMethodSignature);
		
		//Arguments
		Object[] theArguments = theJoinPoint.getArgs();
			//loop arguments
			for (int i = 0; i< theArguments.length; i++) {
				System.out.println("Argument["+i+"] = " + theArguments[i]);
				if(theArguments[i] instanceof Subscription) {
					//System.out.println("Argument["+i+"] = " + ((Subscription) theArguments[i]).getName());
					
					Subscription theSubscription = (Subscription) theArguments[i];
					System.out.println("Subscription Name= " + theSubscription.getName());
					System.out.println("Subscription Email = " + theSubscription.getEmail());
					System.out.println("Subscription Id = " + theSubscription.getId());
				}
			}
		
	}
}
