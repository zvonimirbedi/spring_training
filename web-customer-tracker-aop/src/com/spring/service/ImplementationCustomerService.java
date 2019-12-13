package com.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.InterfaceDAOCustomer;
import com.spring.entity.EntityCustomer;

@Service
public class ImplementationCustomerService implements InterfaceCustomerService {
	
	
	// inject customer dao
	
	@Autowired
	private InterfaceDAOCustomer theInterfaceDAOCustomer;
	
	
	@Override
	@Transactional
	public List<EntityCustomer> geEntityCustomers() {
		return theInterfaceDAOCustomer.geEntityCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(EntityCustomer theEntityCustomer) {

		theInterfaceDAOCustomer.saveCustomer(theEntityCustomer);
		
	}


	@Override
	@Transactional
	public EntityCustomer geEntityCustomers(int theId) {
		return theInterfaceDAOCustomer.geEntityCustomers(theId);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		theInterfaceDAOCustomer.deleteCustomer(theId);
		
	}

}
