package com.zvone.springboot.thymeleafapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zvone.springboot.thymeleafapp.entity.EntityEmployee;

//@RepositoryRestResource(path="employees")
public interface InterfaceJpaRepositoryEmployee extends JpaRepository<EntityEmployee, Integer> {
	
	// add ethod to sort by last name
	public List<EntityEmployee> findAllByOrderByLastNameAsc();

}
