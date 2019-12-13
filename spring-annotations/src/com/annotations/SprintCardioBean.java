package com.annotations;

import org.springframework.stereotype.Component;

@Component
public class SprintCardioBean implements CardioInterface {

	@Override
	public String getCardioWorkout() {
		return "Do 10 repetitions of 100 dash, High Intensity!";
	}

}
