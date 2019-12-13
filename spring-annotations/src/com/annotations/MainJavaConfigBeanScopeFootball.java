package com.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfigBeanScopeFootball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigSportFootball.class);
		
		CoachInterface theCoach = theContext.getBean("footballCoachBean",CoachInterface.class);

		System.out.println("MainJavaConfigBeanScopeFootball: getDailyCardio: " + theCoach.getDailyCardio() );
		System.out.println("MainJavaConfigBeanScopeFootball: getDailyWorkout: " + theCoach.getDailyWorkout() );
		
		theContext.close();

	}

}
