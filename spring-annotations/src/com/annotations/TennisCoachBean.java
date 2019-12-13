package com.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoachBean implements CoachInterface {

	@Override
	public String getDailyWorkout() {
		return "Practice backhand for 20min!";
	}

	@Override
	public String getDailyCardio() {
		// TODO Auto-generated method stub
		return "Run 5k, medium intenisty!";
	}
	
	public TennisCoachBean() {
		System.out.println("TennisCoachBean: Kontstrutor pokrenut");
		
	}
	
	//define init method 
	@PostConstruct
	public void init() {
		System.out.println("TennisCoachBean: Init method pokrenut");
		}
	
	//define destroy method	
	@PreDestroy
	public void preDestroy() {
	System.out.println("TennisCoachBean: PreDestroy method pokrenut");
	}

}
