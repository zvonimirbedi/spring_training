package com.annotations;

import org.springframework.stereotype.Component;

@Component
public class StaircaseCardioBean implements CardioInterface {

	@Override
	public String getCardioWorkout() {
		// TODO Auto-generated method stub
		return "Do 1000 staircase steps, up and down!";
	}

}
