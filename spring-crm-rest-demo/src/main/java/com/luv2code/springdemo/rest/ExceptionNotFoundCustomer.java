package com.luv2code.springdemo.rest;

public class ExceptionNotFoundCustomer extends RuntimeException {

	public ExceptionNotFoundCustomer() {
	}

	public ExceptionNotFoundCustomer(String arg0) {
		super(arg0);
	}

	public ExceptionNotFoundCustomer(Throwable arg0) {
		super(arg0);
	}

	public ExceptionNotFoundCustomer(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExceptionNotFoundCustomer(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
