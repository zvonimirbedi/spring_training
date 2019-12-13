package com.zvone.spring.entity;

public class PojoStudent {

	private String firstName;
	private String lastName;
	
	public PojoStudent() {
	}

	public PojoStudent(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	
	
}
