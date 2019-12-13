package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutUtility {	
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void pointcutPackageFunction() {};
	
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	public void pointcutGetterFunction() {};
	
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	public void pointcutSetterFunction() {};
	
	@Pointcut("pointcutPackageFunction() && !(pointcutGetterFunction() || pointcutSetterFunction())")
	public void pointcutPackageNotGetterNotSetterFunction() {};
}
