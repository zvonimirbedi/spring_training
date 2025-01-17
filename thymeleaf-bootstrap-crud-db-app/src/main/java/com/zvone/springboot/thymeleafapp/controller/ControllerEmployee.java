package com.zvone.springboot.thymeleafapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zvone.springboot.thymeleafapp.entity.EntityEmployee;
import com.zvone.springboot.thymeleafapp.service.InterfaceServiceEmployee;


@Controller
@RequestMapping("/employees")
public class ControllerEmployee {
	
	private InterfaceServiceEmployee employeeService;
	
	@Autowired
	public ControllerEmployee(InterfaceServiceEmployee theEmployeeService) {
		employeeService = theEmployeeService;
	}

	//add mapping for "/list"
	@GetMapping("/list")
	public String getListEmployees(Model theModel) {
		 
		List<EntityEmployee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("entityEmployees", theEmployees);		
		return "employees/list-employees";
	}
	
	//add mapping for "/list"
	@GetMapping("/add-new-employee")
	public String addNewEmployee(Model theModel) {
		 
		EntityEmployee theEmployees = new EntityEmployee();
		
		theModel.addAttribute("entityEmployees", theEmployees);		
		return "employees/employee-form";
	}
	
	@GetMapping("/edit-employee")
	public String editEmployee(@RequestParam("employeeId") int theId, Model theModel)
	{
		EntityEmployee theEmployees = employeeService.findById(theId);
		
		theModel.addAttribute("entityEmployees", theEmployees);	
		return "employees/employee-form";
	}
	
	//add mapping for "/list"
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		 
		
		employeeService.deleteById(theId);		
		return "redirect:/employees/list";
	}
	
	//add mapping for "/list"
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("entityEmployees") EntityEmployee theEmployee) {
		 
		
		employeeService.saveOrUpdate(theEmployee);		
		return "redirect:/employees/list";
	}
	



}
