package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoachBean implements CoachInterface {

	@Autowired
	@Qualifier("randomCardioBean")
	private CardioInterface cardio;
	
	public BasketballCoachBean() {
		System.out.println("BasketballCoachBean: Kontstrutor pokrenut");
		
	}
	public CardioInterface getCardio() {
		return cardio;
	}
	
	/*
	@Autowired
	public void neserifakatradi (CardioInterface cardio) {
		System.out.println("Setter setCardio u BasketballCoachBean pokrenut");
		this.cardio = cardio;
	}
	*/
	
	/*
	@Autowired
	public void setCardio(CardioInterface cardio) {
		System.out.println("Setter setCardio u BasketballCoachBean pokrenut");
		this.cardio = cardio;
	}/*
	
	/*
	@Autowired 
	public BasketballCoachBean(CardioInterface cardio) {
		this.cardio = cardio;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Do 500 freethrows!";
	}

	@Override
	public String getDailyCardio() {
		return cardio.getCardioWorkout();
	}
	

}
