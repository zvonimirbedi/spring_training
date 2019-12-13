package com.spring.dao;

import java.util.List;

import com.spring.entity.EntityCustomer;

public interface InterfaceDAOCustomer {
	
	public List<EntityCustomer> geEntityCustomers();

	public void saveCustomer(EntityCustomer theEntityCustomer);

	public EntityCustomer geEntityCustomers(int theId);

	public void deleteCustomer(int theId);

}
