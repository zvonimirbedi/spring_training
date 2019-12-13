package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@ComponentScan("com.annotations")
@Configuration
@PropertySource("classpath:coach.properties")
public class ConfigSport {
	
	//define a method to expose a bean CyclingCardioBean
	@Bean 
	public CardioInterface cyclingCardioBean() {
		return new CyclingCardioBean(); 
		
	}
	
	//define a method to expose a bean SwimCoachBean and inject dependecy
	@Bean
	public CoachInterface swimCoachBean() {
		return new SwimCoachBean(cyclingCardioBean());
		
	}
	

}
