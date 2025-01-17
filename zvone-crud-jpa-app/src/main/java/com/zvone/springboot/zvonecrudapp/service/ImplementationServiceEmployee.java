package com.zvone.springboot.zvonecrudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zvone.springboot.zvonecrudapp.dao.InterfaceDAOEmployee;
import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;

@Service
public class ImplementationServiceEmployee implements InterfaceServiceEmployee {

	
	private InterfaceDAOEmployee employeDAO;
	
	@Autowired
	public ImplementationServiceEmployee(InterfaceDAOEmployee theEmployeDAO) {
		employeDAO = theEmployeDAO;
	}
		
	
	@Override
	@Transactional
	public List<EntityEmployee> findAll() {
		return employeDAO.findAll();
	}

	@Override
	@Transactional
	public EntityEmployee findById(int theId) {
		return employeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveOrUpdate(EntityEmployee theEmployee) {
		employeDAO.saveOrUpdate(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeDAO.deleteById(theId);
	}

}
