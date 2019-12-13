package com.zvone.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerLogin {
	
	@GetMapping("/myLoginPage")
	public String myLoginPage() {
		//return "plain-login";
		return "fancy-login";
	}

}
