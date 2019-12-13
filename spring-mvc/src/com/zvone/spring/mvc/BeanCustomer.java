package com.zvone.spring.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.zvone.spring.mvc.validation.CourseCode;

public class BeanCustomer {

	private String firstName;	
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String lastName;
	
	@Min(value=0, message="must be greather or equal than zero")
	@Max(value=10, message="mus be less or equal to 10")
	@NotNull(message="is required!")
	private Integer freePass;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postCode;

	@CourseCode(value={"TOPS", "LUV"}, message="Must start with TOPS or LUV!")
	private String courseCode;
	
	
	
	public BeanCustomer() {}
	
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

	public Integer getFreePass() {
		return freePass;
	}

	public void setFreePass(Integer freePass) {
		this.freePass = freePass;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
}
