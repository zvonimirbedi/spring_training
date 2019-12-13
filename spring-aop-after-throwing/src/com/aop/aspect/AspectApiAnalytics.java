package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AspectApiAnalytics {
	@Before("com.aop.aspect.PointcutUtility.pointcutPackageFunction()")
	public void monitorApi() {
		System.out.println("@Before - " + getClass() + ": Monitor API execution @Before advice on method");
	}
	
	@Before("com.aop.aspect.PointcutUtility.pointcutPackageNotGetterNotSetterFunction()")
	public void monitorApiNotGetter() {
		System.out.println("@Before - " + getClass() + ": Monitor API Not Getter execution @Before advice on method");
	}
}
