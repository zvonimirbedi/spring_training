package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AspectCloudAsyncLogging {
	@Before("com.aop.aspect.PointcutUtility.pointcutPackageNotGetterNotSetterFunction()")
	public void CloudLoggingNotGetter() {
		System.out.println("@Before - " + getClass() + ": Log to Cloud Not Getter execution @Before advice on method");
	}	
}
