package com.zvone.springboot.thymeleafapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerSpringMVC {
	
	// create a mapping for "/hello"
	
	@GetMapping("/hello")
	public String getHelloWorld(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "helloworld";
	}

}
