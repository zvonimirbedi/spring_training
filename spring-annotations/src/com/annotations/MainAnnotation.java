package com.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext thecontxt = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

		//get the bean froom spring container
		CoachInterface trener = thecontxt.getBean("basketballCoachBean", CoachInterface.class);
		
		//call a method on the bean
		System.out.println(trener.getDailyWorkout());

		System.out.println(trener.getDailyCardio());

		
		
		//close the context
		thecontxt.close();  
	}

}
