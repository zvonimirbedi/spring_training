package com.zvone.springboot.zvonecrudapp.rest;

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

import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;
import com.zvone.springboot.zvonecrudapp.service.InterfaceServiceEmployee;

@RestController
@RequestMapping("/api")
public class ControllerRestEmployee {
	
	private InterfaceServiceEmployee employeeService;
	
	@Autowired
	public ControllerRestEmployee (InterfaceServiceEmployee theEmployeeService) {
		employeeService = theEmployeeService;		
	}
	
	@GetMapping("/employees")
	public List<EntityEmployee> findAll(){
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public EntityEmployee getEmployee (@PathVariable int employeeId) {
		EntityEmployee theEmployee = employeeService.findById(employeeId);		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id does not exist - " + employeeId);
		}		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public EntityEmployee saveEmployee(@RequestBody EntityEmployee theEmployee) {		
		theEmployee.setId(0);
		employeeService.saveOrUpdate(theEmployee);			
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public EntityEmployee updateEmployee(@RequestBody EntityEmployee theEmployee) {		
		employeeService.saveOrUpdate(theEmployee);			
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {			
		EntityEmployee theEmployee = employeeService.findById(employeeId);	
		if(theEmployee == null) {
			throw new RuntimeException("Employee id does not exist - " + employeeId);
		}	
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employe by id - " + employeeId;
	}

	
	

}
