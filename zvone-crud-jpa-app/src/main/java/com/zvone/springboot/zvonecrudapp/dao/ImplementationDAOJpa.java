package com.zvone.springboot.zvonecrudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zvone.springboot.zvonecrudapp.entity.EntityEmployee;

@Repository
public class ImplementationDAOJpa implements InterfaceDAOEmployee {


	// fields 
	private EntityManager entityManager;
	
	public ImplementationDAOJpa(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<EntityEmployee> findAll() {
		
		// create a query
		Query theQuery = entityManager.createQuery("from EntityEmployee");	
		// exec a query
		@SuppressWarnings("unchecked")
		List<EntityEmployee> employees = theQuery.getResultList();
		
		// return result
		return employees;
	}

	@Override
	public EntityEmployee findById(int theId) {
		
		// get employee		
		EntityEmployee theEmployee = entityManager.find(EntityEmployee.class, theId);	
		
		// return employee
		return theEmployee;
	}

	@Override
	public void saveOrUpdate(EntityEmployee theEmployee) {

		// save or update the em
		EntityEmployee dbEmployee = entityManager.merge(theEmployee);
		
		// update with id from db ... so we can check
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// delete object with pk id
		Query theQuery = entityManager.createQuery("delete from EntityEmployee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
