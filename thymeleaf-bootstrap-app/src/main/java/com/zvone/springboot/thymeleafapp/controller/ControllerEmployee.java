package com.zvone.springboot.thymeleafapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zvone.springboot.thymeleafapp.model.EntityEmployee;

@Controller
@RequestMapping("/employees")
public class ControllerEmployee {
	
	// load employees 
	private List<EntityEmployee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		EntityEmployee emp1 = new EntityEmployee(1,"Ivo","Ivic","IvoIvic@gmail.com");
		EntityEmployee emp2 = new EntityEmployee(2,"Marko","Markic","MarkoMarkic@gmail.com");
		EntityEmployee emp3 = new EntityEmployee(3,"Kika","Kikic","KikaKikic@gmail.com");
		EntityEmployee emp4 = new EntityEmployee(4,"Jozo","Jozic","JoziJozic@gmail.com");
		
	// create the list
		theEmployees = new ArrayList<>();
	
	// add tem employees to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);		
	}

	//add mapping for "/list"
	@GetMapping("/list")
	public String getListEmployees(Model theModel) {
		theModel.addAttribute("entityEmployees", theEmployees);		
		return "list-employees";
	}


}
