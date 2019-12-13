package com.zvone.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerRest {
	
	// add code for the /hello endoint
	@GetMapping("/hello")
	public String getHelloWorld() {
		return "Hello World!";
	}
}
