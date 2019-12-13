package com.annotations;

public class FootballCoachBean implements CoachInterface {
	
	public CardioInterface cardioInterface;
	

	public FootballCoachBean(CardioInterface cardioInterface) {
		super();
		this.cardioInterface = cardioInterface;
	}

	@Override
	public String getDailyWorkout() {
		return "Do 300 penalty kicks!";
	}

	@Override
	public String getDailyCardio() {
		return cardioInterface.getCardioWorkout();
	}

}
