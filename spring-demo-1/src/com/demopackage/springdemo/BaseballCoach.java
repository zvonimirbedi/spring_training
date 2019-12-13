package com.demopackage.springdemo;

public class BaseballCoach  implements CoachInterface {

	
	// define a private field for dependency
	private FortuneInterface fortuneService;
	
	// define a constructor for dependency injection	
	 public BaseballCoach(FortuneInterface fortuneService) {
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		
		// use my fortunese
		return fortuneService.getFortune();
	}


}
