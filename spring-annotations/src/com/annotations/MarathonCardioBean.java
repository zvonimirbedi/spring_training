package com.annotations;

import org.springframework.stereotype.Component;

@Component
public class MarathonCardioBean implements CardioInterface {

	@Override
	public String getCardioWorkout() {
		return "Run 5k medium intesity!";
	}

}
