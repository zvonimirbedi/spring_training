package com.zvone.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zvone.spring.entity.PojoStudent;

@RestController
@RequestMapping("/api")
public class ControllerRestStudent {
	private List<PojoStudent> theStudents = new ArrayList<>();
	
	@PostConstruct
	public void loadData()	{
		theStudents.add(new PojoStudent ("Marko","Markic"));
		theStudents.add(new PojoStudent ("Ivica","Ivikovic"));
		theStudents.add(new PojoStudent ("Zvone","Zvonic"));	
		theStudents.add(new PojoStudent ("Dino","Dinic"));			
	}	
	
	@GetMapping("studentsAll")
	public List<PojoStudent> getStudentsAll(){	
		return theStudents;
	}	
	
	@GetMapping("studentsById/{id}")
	public PojoStudent getStudentsById(@PathVariable int id){
		
		if(id >= theStudents.size() || id <0)
			throw new ExceptionStudentNotFound("Student id not found - " + id);
		return theStudents.get(id);
	}
	
}
