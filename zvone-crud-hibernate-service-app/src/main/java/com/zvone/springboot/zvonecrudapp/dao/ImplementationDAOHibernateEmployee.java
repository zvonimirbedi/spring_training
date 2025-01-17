package com.zvone.springboot.zvonecrudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;


@Repository
public class ImplementationDAOHibernateEmployee implements InterfaceDAOEmployee {
	
	// fields 
	private EntityManager entityManager;	
	
	// constructor injection
	@Autowired
	public ImplementationDAOHibernateEmployee(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
		
	}

	@Override
	public List<EntityEmployee> findAll() {

		// current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// create query
		Query<EntityEmployee> theQuery = currentSession.createQuery("from EntityEmployee", EntityEmployee.class);
		
		// execute the query
		List<EntityEmployee> employee = theQuery.getResultList();
		
		// return the results
		return employee;
	}

	@Override
	public EntityEmployee findById(int theId) {
		
		// current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
		// create query
		EntityEmployee theEmployee  = currentSession.get(EntityEmployee.class, theId);
		
		
		// return the results
		return theEmployee;
	}

	@Override
	public void saveOrUpdate(EntityEmployee theEmployee) {

		// current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
		// save the employee
				currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {

		// current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
		// create query
				Query theQuery = currentSession.createQuery("delete from EntityEmployee where id=:employeeId");
				theQuery.setParameter("employeeId", theId);
				theQuery.executeUpdate();		
	}

}
