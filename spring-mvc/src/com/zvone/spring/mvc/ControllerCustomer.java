package com.zvone.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class ControllerCustomer {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("BeanCustomer", new BeanCustomer());

		return "customerRegistration";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("BeanCustomer") BeanCustomer theCustomer,
			BindingResult theBindingResult) {
		String log = "|" + theCustomer.getFirstName() + "|" + theCustomer.getLastName() + "|" + theCustomer.getFreePass() + "|" + theCustomer.getPostCode() + "|" + theCustomer.getCourseCode() + "|";

		if (theBindingResult.hasErrors()) {
			System.out.println("ZVONE: FAIL: " + log );
			
			// ispis u logu svih errora za debug potrebe
			System.out.println(theBindingResult);
			return "customerRegistration";
		} else {
			System.out.println("ZVONE: WIN: " + log );
			return "customerRegistrationConfirmation";
		}
	}
	
	@InitBinder
	public void initBinderRemoveWhiteSpace(WebDataBinder dataBinder) {
				StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
				dataBinder.registerCustomEditor(String.class, trimmer);
	}

}
