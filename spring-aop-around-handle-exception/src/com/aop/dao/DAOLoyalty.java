package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class DAOLoyalty {

	private String serviceCode;
	private String name; 
	
	public void getDatabaseConnection() {		
		System.out.println(getClass() + ": Doing db work: log in console");
	}
	
	public boolean doWork() {		
		System.out.println(getClass() + ": doing some work doWork()");
		return true;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": doing some work getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": doing some work setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}

	public String getName() {
		System.out.println(getClass() + ": doing some work getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": doing some work setName(String name)");
		this.name = name;
	}
	
	
}
