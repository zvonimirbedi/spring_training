package com.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext thecontext = new AnnotationConfigApplicationContext(ConfigSport.class);
		
		CoachInterface theCoach = thecontext.getBean("tennisCoachBean", CoachInterface.class);

		System.out.println("MainJavaConfig: getDailyWorkout: " +theCoach.getDailyWorkout());
		System.out.println("MainJavaConfig: getDailyCardio: " +theCoach.getDailyCardio());
		
		thecontext.close(); 
		

	}

}
