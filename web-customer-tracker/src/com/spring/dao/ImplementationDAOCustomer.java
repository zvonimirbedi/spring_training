package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.EntityCustomer;

@Repository
public class ImplementationDAOCustomer implements InterfaceDAOCustomer {

	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	//@Transactional
	public List<EntityCustomer> geEntityCustomers() {
		// TODO Auto-generated method stub
		
		//gett the current hibernate session
		Session theCurrentSession = SessionFactory.getCurrentSession();
		
		// query create
		
		Query<EntityCustomer> theQuery = theCurrentSession.createQuery("from EntityCustomer order by last_name", EntityCustomer.class);
		
		//execute query and get result list
		List<EntityCustomer> theCustomers = theQuery.getResultList();
		
		// return the results
		return theCustomers;
	}

	@Override
	public void saveCustomer(EntityCustomer theEntityCustomer) {
		
		Session theCurrentSession = SessionFactory.getCurrentSession();
		theCurrentSession.saveOrUpdate(theEntityCustomer);
		
	}

	@Override
	public EntityCustomer geEntityCustomers(int theId) {
		//gett the current hibernate session
				Session theCurrentSession = SessionFactory.getCurrentSession();				
				
				EntityCustomer theCustomers = theCurrentSession.get(EntityCustomer.class,theId);
				
				// return the results
				return theCustomers;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session theCurrentSession = SessionFactory.getCurrentSession();
		
		Query theQuery = 
				theCurrentSession.createQuery("delete from EntityCustomer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
				
	}

}
