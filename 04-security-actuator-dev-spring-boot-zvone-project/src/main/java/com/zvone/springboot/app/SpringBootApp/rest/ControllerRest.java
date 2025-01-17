package com.zvone.springboot.app.SpringBootApp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {
	
	// expose "/" that return "Hello World"

	@Value ("${coach.name}")
	private String coachName;
	
	@Value ("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String getHelloWorldTime() {
		String out = "Hello World!!! Time on server is: " + LocalDateTime.now();
		return out;
	}
	
	@GetMapping("/cardio")
	public String getCardio() {
		String out = "Do the 5k run!";
		return out;
	}
	
	@GetMapping("/footballteam")
	public String getFootballTeam() {
		String out = "Trainer is: " + coachName + ", team is: " + teamName;
		return out;
	}
	
	
	

}
