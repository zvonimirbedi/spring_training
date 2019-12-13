package com.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotationBeanScope {

	public static void main(String[] args) {

		//load spring config file
		ClassPathXmlApplicationContext thecontext = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		
		//retrieve bean from spring container
		CoachInterface tennisCoach = thecontext.getBean("tennisCoachBean", CoachInterface.class);
		CoachInterface tennisCoachAsistant = thecontext.getBean("tennisCoachBean", CoachInterface.class);
		
		boolean usporedba = (tennisCoach == tennisCoachAsistant);

		System.out.println("MainAnnotationBeanScope: Usporedba trenera: " + usporedba);
		System.out.println("MainAnnotationBeanScope: Memory loc tennisCoach: " + tennisCoach);
		System.out.println("MainAnnotationBeanScope: Memory loc tennisCoachAsistant: " + tennisCoachAsistant);
		
		//close context
		thecontext.close();

	}

}
