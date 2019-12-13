package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class DAOLoyalty {
	
	public void getDatabaseConnection() {		
		System.out.println(getClass() + ": Doing db work: log in console");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doing some work");
		return true;
	}
}
