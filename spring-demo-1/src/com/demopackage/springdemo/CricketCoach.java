package com.demopackage.springdemo;

public class CricketCoach implements CoachInterface {

	private FortuneInterface fortuneService;
	
	
	private String email;
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach: no-arg constructor call");
		
	}
	
	public void setFortuneService(FortuneInterface fortuneService) {
		System.out.println("CricketCoach: setter method call setFortuneService");
		this.fortuneService = fortuneService;
	}

	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach: setter method call setEmail");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: setter method call setTeam");
		this.team = team;
	}

}
