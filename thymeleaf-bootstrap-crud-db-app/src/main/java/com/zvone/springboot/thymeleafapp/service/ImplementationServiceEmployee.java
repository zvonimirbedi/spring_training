package com.zvone.springboot.thymeleafapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zvone.springboot.thymeleafapp.dao.InterfaceJpaRepositoryEmployee;
import com.zvone.springboot.thymeleafapp.entity.EntityEmployee;

@Service
public class ImplementationServiceEmployee implements InterfaceServiceEmployee {

	
	private InterfaceJpaRepositoryEmployee employeDAO;
	
	@Autowired
	public ImplementationServiceEmployee(InterfaceJpaRepositoryEmployee theEmployeDAO) {
		employeDAO = theEmployeDAO;
	}
		
	
	@Override
	public List<EntityEmployee> findAll() {
		return employeDAO.findAllByOrderByLastNameAsc();
	}

	@Override
	public EntityEmployee findById(int theId) {
		Optional<EntityEmployee> result = employeDAO.findById(theId);
		
		EntityEmployee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void saveOrUpdate(EntityEmployee theEmployee) {
		employeDAO.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeDAO.deleteById(theId);
	}

}
