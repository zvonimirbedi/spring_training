package com.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.aop.dao.service.ServiceTraffic;

public class MainLogger {

	private static Logger theLogger = Logger.getLogger(MainLogger.class.getName());

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// get the bean from spring container
		ServiceTraffic theServiceTraffic = theContext.getBean("serviceTraffic", ServiceTraffic.class);

		theLogger.info(MainLogger.class.getName() + " class: MainAround");
		
		theLogger.info("Call class ServiceTraffic method getTraffic();");
		
		String data = theServiceTraffic.getTraffic();

		theLogger.info("My traffic is: " + data);
		
		theLogger.info(MainLogger.class.getName() + " class:  MainAround finish ");
		
		
		// close the context
		theContext.close();

	}

}
