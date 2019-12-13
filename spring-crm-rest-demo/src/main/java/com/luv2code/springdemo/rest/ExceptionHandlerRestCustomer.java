package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerRestCustomer {

	// Add an exception handler for ExceptionNotFoundCustomer
	@ExceptionHandler
	public ResponseEntity<ErrorResponseCustomer> handleException(ExceptionNotFoundCustomer exc){
		
		// create ErrorResponseCustomer
		ErrorResponseCustomer theErrorResponseCustomer = new ErrorResponseCustomer(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		
		// return ResponseEntity	
		return new ResponseEntity<>(theErrorResponseCustomer, HttpStatus.NOT_FOUND);
	}
	
	// Add another exception handler for any other error
	@ExceptionHandler
	public ResponseEntity<ErrorResponseCustomer> handleException(Exception exc){
		
		// create ErrorResponseCustomer
		ErrorResponseCustomer theErrorResponseCustomer = new ErrorResponseCustomer(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		
		// return ResponseEntity	
		return new ResponseEntity<>(theErrorResponseCustomer, HttpStatus.BAD_REQUEST);
	}
}
