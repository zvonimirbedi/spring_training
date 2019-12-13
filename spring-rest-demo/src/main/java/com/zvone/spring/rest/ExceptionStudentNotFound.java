package com.zvone.spring.rest;



public class ExceptionStudentNotFound extends RuntimeException{

	public ExceptionStudentNotFound(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExceptionStudentNotFound(String arg0) {
		super(arg0);
	}

	public ExceptionStudentNotFound(Throwable arg0) {
		super(arg0);
	}

	
}
