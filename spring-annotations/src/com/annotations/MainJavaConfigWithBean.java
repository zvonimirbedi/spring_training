package com.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfigWithBean {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext theContext = new AnnotationConfigApplicationContext(ConfigSport.class);
		
		SwimCoachBean theCoach = theContext.getBean("swimCoachBean", SwimCoachBean.class);
		

		System.out.println("MainJavaConfigWithBean: getDailyWorkout: " +theCoach.getDailyWorkout());
		System.out.println("MainJavaConfigWithBean: getDailyCardio: " +theCoach.getDailyWorkout());
		System.out.println("MainJavaConfigWithBean: getTeam: " +theCoach.getTeam());
		System.out.println("MainJavaConfigWithBean: getEmail: " +theCoach.getEmail());
		
		
		theContext.close();
		
	}

}
