package com.demopackage.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPrototypeBeans {

	public static void main(String[] args) {

		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContextPrototype.xml");
		
		//get beans from spring container
		CoachInterface theCoach = context.getBean("myCoach", CoachInterface.class);
		CoachInterface theCoachCardio = context.getBean("myCoach", CoachInterface.class);
		
		boolean compareCoach = (theCoach == theCoachCardio);

		System.out.println("Pointing to same object: " + compareCoach);
		System.out.println("Memory Location Coach Cardio: " + theCoach);
		System.out.println("Memory Location Coach Cardio: " + theCoachCardio);
		
		context.close();

	}

}
