package com.annotations;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomCardioBean implements CardioInterface {

	
	@Value("${cardio.list}")
	private String[] cardioList;
	
	
	
	@Override
	public String getCardioWorkout() {
		
		 // create random object 
        Random ran = new Random(); 
  
        int random_number = ran.nextInt(cardioList.length); 		
		return cardioList[random_number] ;
	}
	
	@PostConstruct
	public void init () {		
		System.out.println("RandomCardioBean: Init method pokrenut");		
	}
	

}
