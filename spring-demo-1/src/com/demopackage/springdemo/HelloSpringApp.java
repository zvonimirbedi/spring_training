package com.demopackage.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextSingleton.xml");
		
		//retrieve bean from spring container
		CoachInterface theCoach = context.getBean("myCoach", CoachInterface.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call new method from fortunes
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
		
	}

}
