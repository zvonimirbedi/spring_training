package com.demopackage.springdemo;

public class TrackCoach implements CoachInterface {

	
	// define a private field for dependency
	private FortuneInterface fortuneService;
	
	public TrackCoach(FortuneInterface fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run mofo, run 5k!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it tracker: " + fortuneService.getFortune();
	}
	
	public void init() {	
		System.out.println("Singleton TrackCoach init method call");				
		}
	
	public void destroy() {		
		System.out.println("Singleton TrackCoach destroy method call");		
		
	}

}
