package com.demopackage.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		// load the spring config file -> applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContextSingleton.xml");
		
		// retrivece bean from string container -> applicationContext.xml -> bean id
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		

		System.out.println(theCoach.getTeam());
		System.out.println(theCoach.getEmail());
		
		
		// close the context
		context.close();
		

	}

}
