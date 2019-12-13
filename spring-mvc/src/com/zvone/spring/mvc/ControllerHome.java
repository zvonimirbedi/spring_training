package com.zvone.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHome {
	
	@RequestMapping("/")
	public String showPage() {
		
		return "index";
	}
}
