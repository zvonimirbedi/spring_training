package com.zvone.springboot.app.SpringBootApp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {
	
	// expose "/" that return "Hello World"
	
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
	

}
