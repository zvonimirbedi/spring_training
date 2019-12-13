package com.annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoachBean implements CoachInterface {

	private CardioInterface cardioInterface;	
	
	@Value("${coach.email}")
	private String email;

	@Value("${coach.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimCoachBean(CardioInterface cardioInterface) {
		cardioInterface = cardioInterface;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000m up and down with the spin!";
	}

	@Override
	public String getDailyCardio() {
		return cardioInterface.getCardioWorkout();
	}

}
