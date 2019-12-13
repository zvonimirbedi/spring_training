package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.DAOLoyalty;
import com.aop.dao.DAOSubscription;

public class Main {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// get the bean from spring container
		DAOSubscription theDAOSubscription = theContext.getBean("DAOSubscription", DAOSubscription.class);
		
		// get the bean from spring container
		DAOLoyalty theDAOLoyalty = theContext.getBean("DAOLoyalty", DAOLoyalty.class);
		
		// call the business method		
		theDAOLoyalty.getDatabaseConnection();
		
		// call the business method	
		Subscription mySubscription = new Subscription();
		theDAOSubscription.getServerConnection(mySubscription, false);

		// call new business methods
		theDAOLoyalty.doWork();
		theDAOSubscription.goToSleep();
		
		// close the context
		theContext.close();

	}

}
