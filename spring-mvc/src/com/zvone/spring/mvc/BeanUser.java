package com.zvone.spring.mvc;

import java.util.LinkedHashMap;


public class BeanUser {

	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryList;
	private String favouriteProgrammingLanguage;
	private LinkedHashMap<String, String> programmingLanguageList;
	private String[] usedOSs;
	private LinkedHashMap<String, String> OSList;

	
	public BeanUser() {
		//fillCountryList();
		fillProgrammingLanguageList();
		fillOSList();
	}

	public String[] getUsedOSs() {
		return usedOSs;
	}




	public void setUsedOSs(String[] usedOSs) {
		this.usedOSs = usedOSs;
	}




	public void setOSList(LinkedHashMap<String, String> oSList) {
		OSList = oSList;
	}




	public LinkedHashMap<String, String> getOSList() {
		return OSList;
	}


	public LinkedHashMap<String, String> getProgrammingLanguageList() {
		return programmingLanguageList;
	}


	public void setProgrammingLanguageList(LinkedHashMap<String, String> programmingLanguageList) {
		this.programmingLanguageList = programmingLanguageList;
	}


	public void setCountryList(LinkedHashMap<String, String> countryList) {
		this.countryList = countryList;
	}


	public String getFavouriteProgrammingLanguage() {
		return favouriteProgrammingLanguage;
	}

	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryList() {
		return countryList;
	}
	private void fillCountryList() {
		countryList = new LinkedHashMap<String, String>();

		countryList.put("BR", "Brasil");
		countryList.put("FR", "France");
		countryList.put("DE", "Germany");
		countryList.put("HR", "Croatia");
		countryList.put("US", "United States of America");		
	}
	
	private void fillProgrammingLanguageList() {
		programmingLanguageList = new LinkedHashMap<String, String>();

		programmingLanguageList.put("Java", "Java");
		programmingLanguageList.put("C#", "C#");
		programmingLanguageList.put("PHP", "PHP");
		programmingLanguageList.put("C++", "C++");
		programmingLanguageList.put("Ruby", "Ruby");	
		
	}
	private void fillOSList() {		
		OSList = new LinkedHashMap<String, String>();
		OSList.put("Windows", "Windows");
		OSList.put("Ubuntu", "Ubuntu");
		OSList.put("Mac", "Mac");
}	

		
}
