package com.zvone.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainDriver {

	public static void main(String[] args) {		
		
		try {
			
			//create object mapper
			ObjectMapper theMapper = new ObjectMapper();
			
			
			// read JSON file and map/convert to POJO
			
			// data/sample-lite.json
			//PojoStudent theStudent = theMapper.readValue(new File("data/sample-lite.json"), PojoStudent.class);
			
			// data/sample-full.json
			PojoStudent theStudent = theMapper.readValue(new File("data/sample-full.json"), PojoStudent.class);


			// print fields
			System.out.println("ZVONE: First Name = " + theStudent.getFirstName());
			System.out.println("ZVONE: Last Name = " + theStudent.getLastName());
			
			PojoStudentAddress theStudentAddress = theStudent.getAddress();
			

			System.out.println("ZVONE: Street = " + theStudentAddress.getStreet());
			System.out.println("ZVONE: City = " + theStudentAddress.getCity());
			
			//print out languages
			
			for(int i=0; i< theStudent.getLanguages().length; i++) {
				System.out.println("ZVONE: Language ("+ i +") = " + theStudent.getLanguages()[i]);
				
			}
			
			
		}
		catch(Exception exc)
		{exc.printStackTrace();}

	}

}
