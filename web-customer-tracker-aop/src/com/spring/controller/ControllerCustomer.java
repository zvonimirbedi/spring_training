package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.EntityCustomer;
import com.spring.service.InterfaceCustomerService;

@Controller
@RequestMapping("/customer")
public class ControllerCustomer {
	
	/*
	// need to inject the customer dao
	@Autowired
	private InterfaceDAOCustomer theInterfaceDAOCustomer;
	*/
	
	// need to inject the customer service
	@Autowired
	private InterfaceCustomerService theInterfaceCustomerService;
	
	@GetMapping("/list")
	public String listCusomers(Model theModel) {
		
		// get customers from the dao
		//List<EntityCustomer> theCustomers = InterfaceCustomerService.geEntityCustomers();
		
		
		List<EntityCustomer> theCustomers = theInterfaceCustomerService.geEntityCustomers();
		
		// add the customer to the spring MVC model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";	
		
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		EntityCustomer theCustomer = new EntityCustomer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") EntityCustomer theEntityCustomer)
	{
		theInterfaceCustomerService.saveCustomer(theEntityCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("customerId") int theId,
		Model theModel) {		
		
		EntityCustomer theCustomer = theInterfaceCustomerService.geEntityCustomers(theId); 
		
		theModel.addAttribute("customer", theCustomer);
				
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		theInterfaceCustomerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	

}
