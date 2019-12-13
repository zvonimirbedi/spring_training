 package com.demopackage.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainInitDestroyBeansBasketball {

	public static void main(String[] args) {

		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContextInitDestroy.xml");
		
		//get beans from spring container
		CoachInterface theCoach = context.getBean("myBasketballCoach", CoachInterface.class);
		
		System.out.println("Basketball Main class called and done" );
		
		context.close();
	}

}
