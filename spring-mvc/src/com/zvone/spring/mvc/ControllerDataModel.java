package com.zvone.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class ControllerDataModel {
	
	@RequestMapping("/processFormUppercaseWord")
	public String processFormUppercaseWord(HttpServletRequest request, Model model ) {
		
		String theName = request.getParameter("userName");		
		
		theName = theName.toUpperCase();
		
		String result = "YO! " + theName;
		
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
	
	@RequestMapping("/requestParamProcessFormUppercaseWord")
	public String requestParamProcessFormUppercaseWord(@RequestParam("userName") String theName, Model model ) {
		
		theName = theName.toUpperCase();
		
		String result = "YO YO! " + theName;
		
		model.addAttribute("message", result);
		
		return "helloWorld";
	}

}
