package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {
	
	private Logger theLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.spring.controller.*.*(..))")
	public void pointcutForPackageController() {} 
	
	
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	public void pointcutForPackageDao() {} 
	
	
	@Pointcut("execution(* com.spring.service.*.*(..))")
	public void pointcutForPackageService() {} 
	
	@Pointcut("pointcutForPackageController() || pointcutForPackageDao() || pointcutForPackageService()")
	public void pointcutForPackageControllerDaoService() {}
	
	@Before("pointcutForPackageControllerDaoService()")
	public void beforeAspect(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		theLogger.info("Logger Class: " + getClass().getName() + " @Before " + theMethod + " starting");
		
		Object[] theObjectArgs = theJoinPoint.getArgs();
		
		for(int i = 0; i< theObjectArgs.length; i++) {
			theLogger.info("arguments: " +theObjectArgs[i]);
		}
		
	}
	
	@AfterReturning(pointcut = "pointcutForPackageControllerDaoService()", returning ="theResult")
	public void afterReturnAdvice(JoinPoint theJoinPoint, Object theResult ) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		theLogger.info("Logger Class: " + getClass().getName() + " @Before" + theMethod + " starting");
		theLogger.info("Logger result: " + theResult);		
	}

}
