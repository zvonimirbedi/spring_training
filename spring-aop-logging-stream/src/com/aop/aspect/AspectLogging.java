package com.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger theLogger = Logger.getLogger(AspectLogging.class.getName());
	
	// start with @Before advice
	// @Before("execution(public void getDatabaseConnection())")
	// @Before("execution(public void com.aop.dao.DAOLoyalty.getDatabaseConnection())")
	// @Before("execution(public void get*())")
	// @Before("execution(void get*())")
	// @Before("execution(* get*())")
	// @Before("execution(* get*(..))")
/*	@Before("com.aop.aspect.PointcutUtility.pointcutPackageFunction()")
	private void beforeGetDatabaseConnection() {
		theLogger.info("@Before - " + getClass() + ": loging  execution @Before advice on method");
	}*/
	@Before("com.aop.aspect.PointcutUtility.pointcutPackageFunction()")
	public void beforeGetDatabaseConnection(JoinPoint theJoinPoint) {		
		//Class name 
		theLogger.info("@Before - " + getClass() + ": loging  execution @Before advice on method");
		
		//Method name 
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		theLogger.info("Method: " + theMethodSignature);
		
		//Arguments
		Object[] theArguments = theJoinPoint.getArgs();
			//loop arguments
			for (int i = 0; i< theArguments.length; i++) {
				theLogger.info("Argument["+i+"] = " + theArguments[i]);
				if(theArguments[i] instanceof Subscription) {
					//theLogger.info("Argument["+i+"] = " + ((Subscription) theArguments[i]).getName());
					
					Subscription theSubscription = (Subscription) theArguments[i];
					theLogger.info("Subscription Name = " + theSubscription.getName());
					theLogger.info("Subscription Email = " + theSubscription.getEmail());
					theLogger.info("Subscription Id = " + theSubscription.getId());
				}
			}
		
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.aop.dao.DAOSubscription.findSubscriptions(..))",
			returning="result")
	public void afterReturnMain(JoinPoint theJoinPoint, List<Subscription> result) {
		
		String methodName = theJoinPoint.getSignature().toShortString();
		theLogger.info("@AfterReturning method: " + methodName);
		theLogger.info("List<Subscription> result: " + result);		

		converteToUppercaseResult(result);
		
	}

	public void converteToUppercaseResult(List<Subscription> result) {
		
		
		for (int i = 0; i< result.size() ; i++) {
			String theUpercaseVersion = result.get(i).getName().toUpperCase();
			result.get(i).setName(theUpercaseVersion);
		}
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.aop.dao.DAOSubscription.findSubscriptions(..))",
			throwing ="theException")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theException)
	{
		String methodName = theJoinPoint.getSignature().toShortString();
		theLogger.info("@AfterThrowing method: " + methodName);
		theLogger.info("Throwing the Exception: " + theException);
		
	}
	
	@After(
			"execution(* com.aop.dao.DAOSubscription.findSubscriptions(..))")
	public void afterFinallyAdvice(JoinPoint theJoinPoint)
	{
		String methodName = theJoinPoint.getSignature().toShortString();
		theLogger.info("@After (finally) method: " + methodName);
		
	}
	
	@Around(
			"execution(* com.aop.dao.service.ServiceTraffic.getTraffic(..))")
	public Object aroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String methodName = theProceedingJoinPoint.getSignature().toShortString();
		theLogger.info("@Around method: " + methodName);
		
		long startTime = System.currentTimeMillis();		
		Object result = theProceedingJoinPoint.proceed();
		long endTime = System.currentTimeMillis();		
		long durationTime = startTime-endTime;

		theLogger.info("@Around method - traffic duration time: " + durationTime / 1000.0 + "s");
		
		return result;
	}
	
	
}
