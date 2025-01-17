package com.zvone.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PojoStudent {
	
	private int id;
	private String firstName ; 
	private String lastName ; 
	private boolean active ;
	private String[] languages; 
	

	private PojoStudentAddress address;
	
	
	public PojoStudent() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	public PojoStudentAddress getAddress() {
		return address;
	}
	public void setAddress(PojoStudentAddress address) {
		this.address = address;
	} 
	

	public String[] getLanguages() {
		return languages;
	}


	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	
	
	

}
