package com.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.DAOSubscription;

public class MainAfterFinally {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// get the bean from spring container
		DAOSubscription theDAOSubscription = theContext.getBean("DAOSubscription", DAOSubscription.class);
		
		// call the business method	
		List <Subscription> theSubscriptions = null;
		
		try{
			boolean trpwire = true;
		theSubscriptions = theDAOSubscription.findSubscriptions(trpwire);
		}
		catch(Exception theCaughtException) {
			System.out.println("Main class: Exception caught - " + theCaughtException);
		}
		
		//display the subbscriptions
		System.out.println("Main class MainAfterReturn: ");
		System.out.println(theSubscriptions);
		
		// close the context
		theContext.close();

	}

}
