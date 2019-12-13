package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSportFootball {
	
	//define a method to expose a bean ClimbingCardioBean
	@Bean
	public CardioInterface climbingCardioBean() {
		return new ClimbingCardioBean();
	}
	
	//define a method to expose a bean FootballCoachBean and inject dependecy
	@Bean
	public CoachInterface footballCoachBean() {
		return new FootballCoachBean(climbingCardioBean());		
	}

}
