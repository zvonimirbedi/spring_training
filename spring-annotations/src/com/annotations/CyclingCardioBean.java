package com.annotations;

public class CyclingCardioBean implements CardioInterface {

	@Override
	public String getCardioWorkout() {
		return "Do Tabata stationary bike cardio workout, 30 min!";
	}

}
