package com.annotations;

import org.springframework.stereotype.Component;

@Component
public class RopeJumpsCardioBean implements CardioInterface {

	@Override
	public String getCardioWorkout() {
		// TODO Auto-generated method stub
		return "Do 1000 rope jumps!";
	}

}
