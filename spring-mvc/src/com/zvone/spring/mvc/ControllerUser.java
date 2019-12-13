package com.zvone.spring.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ControllerUser {
	

	@Value("#{countryList}") 
	private LinkedHashMap<String, String> countryList;
	
	@RequestMapping("/mappingLoginForm")
	public String showForm(Model theModel) {
		
		BeanUser theUser = new BeanUser();

		theModel.addAttribute("userLogin", theUser);
		theModel.addAttribute("countryList", countryList);
		
		return "loginUser";		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("BeanUser") BeanUser theUser) {

		System.out.println("User Login:" + theUser.getFirstName() + " " + theUser.getLastName() +", "+ theUser.getCountry());

		System.out.println(countryList);

		String[] os = theUser.getUsedOSs();
		System.out.println("User OSs: ");
		for (int i = 0; i < os.length; i++) {
			  System.out.println(os[i]);
		}

		
		
		return "userConfirmation";
	}
	
	
	
	
	

}
