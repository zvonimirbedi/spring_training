package com.demopackage.springdemo;


public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the object
		CoachInterface theCoach = new TrackCoach();  
		
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());

	}

}
