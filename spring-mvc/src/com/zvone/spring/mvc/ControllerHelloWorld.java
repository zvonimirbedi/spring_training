package com.zvone.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerHelloWorld {
	
	// new a controller method to show the init HTML form
	@RequestMapping("/mappingLoginForm")
	public String mappingLoginForm() {
		return "helloWorldForm";		
	}
	
	// neww a controller method to process the form	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";		
	}
	
}
