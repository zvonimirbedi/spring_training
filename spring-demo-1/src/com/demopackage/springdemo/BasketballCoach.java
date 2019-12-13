package com.demopackage.springdemo;

public class BasketballCoach implements CoachInterface {

	// define a private field for dependency
	private FortuneInterface fortuneService;
	
	public BasketballCoach(FortuneInterface fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "100 free throws exercise";
	}

	@Override
	public String getDailyFortune() {
		return "100 free throws exercise";
	}

	public void init() {	
		System.out.println("Prototype BasketballCoach init method call");				
		}
	
	public void destroy() {		
		System.out.println("Prototype BasketballCoach destroy method call");		
		
	}
}
