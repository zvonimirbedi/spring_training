package com.zvone.springboot.zvonecrudapp.dao;

import java.util.List;

import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;

public interface InterfaceDAOEmployee {
	
	// find all rows
	public List<EntityEmployee> findAll();
	
	// select row by id
	public EntityEmployee findById(int theId);
	
	// save row
	public void saveOrUpdate(EntityEmployee theEmployee);
	
	// delete row
	public void deleteById(int theId);
	
	
	
	
}
