package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.aop.dao.service.ServiceTraffic;

public class MainAround {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// get the bean from spring container
		ServiceTraffic theServiceTraffic = theContext.getBean("serviceTraffic", ServiceTraffic.class);

		System.out.println("Main program: MainAround");
		
		System.out.println("Call class ServiceTraffic method getTraffic();");
		
		String data = theServiceTraffic.getTraffic();

		System.out.println("My traffic is: " + data);
		
		System.out.println("Main program: MainAround finish ");
		
		
		// close the context
		theContext.close();

	}

}
