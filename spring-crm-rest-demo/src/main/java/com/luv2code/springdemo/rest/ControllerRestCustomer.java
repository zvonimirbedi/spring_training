package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class ControllerRestCustomer {
	
	// autowire  the CoustomerService
	@Autowired
	private CustomerService theCustomerService;
	
	// add mapping for GET '/customers'
	@GetMapping("/customers")
	public List<Customer> getCustomers(){		
		return theCustomerService.getCustomers();
	}
	
	
	// add mapping for GET '/customers'
	@GetMapping("/customers/{customerid}")
	public Customer getCustomers(@PathVariable int customerid){		
		Customer theCustomer = theCustomerService.getCustomer(customerid);
		
		if(theCustomer == null)
			throw new ExceptionNotFoundCustomer("Not Foound Customer id: " + customerid);
			
		return theCustomer;
	}
	
	// add mapping for post /customers -- add new customer to DB
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		theCustomerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for put /customers -- update existing customer in the DB
	@PutMapping("/customers")
	public Customer updateCustomer (@RequestBody Customer theCustomer){
		
		theCustomerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for delete /customer -- delete exiting customer in the DB
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id ) {
		
		Customer theCustomer = theCustomerService.getCustomer(id);
		if(theCustomer == null)
				throw new ExceptionNotFoundCustomer("Deleting, but Customer id not found: " + id);
		
				
		theCustomerService.deleteCustomer(id);
		
		return "Deleted the customer with id: "+ id;
	}
	
	
}
