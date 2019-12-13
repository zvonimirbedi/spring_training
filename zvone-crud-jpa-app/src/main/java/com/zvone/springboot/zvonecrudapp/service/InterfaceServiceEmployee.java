package com.zvone.springboot.zvonecrudapp.service;

import java.util.List;

import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;

public interface InterfaceServiceEmployee {
	
	// find all rows
	public List<EntityEmployee> findAll();
	
	// select row by id
	public EntityEmployee findById(int theId);
	
	// save row
	public void saveOrUpdate(EntityEmployee theEmployee);
	
	// delete row
	public void deleteById(int theId);
	

}
