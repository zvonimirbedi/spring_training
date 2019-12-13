package com.zvone.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerApp {
	
		@GetMapping("/myLoginPage")
		public String myLoginPage() {
			//return "plain-login";
			return "fancy-login";
		}
		
		
		@GetMapping("/access-denied")
		public String showAccessDenied() {
			//return "plain-login";
			return "accessDenied";
		}

	   @GetMapping("/")
	    public String showLanding() {
	        return "landing";
	    }		
			
		
		@GetMapping("/employees")
		public String showHome() {
			
			return "home";
		}
		
		// add request mapping for /leaders

		@GetMapping("/leaders")
		public String showLeaders() {
			
			return "leaders";
		}
		
		// add request mapping for /systems
		
		@GetMapping("/systems")
		public String showSystems() {
			
			return "systems";
		}


}
