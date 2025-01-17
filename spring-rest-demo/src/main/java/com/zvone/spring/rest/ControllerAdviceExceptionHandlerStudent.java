package com.zvone.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandlerStudent {
	
	// add exception handling code
	
	// Add an exception handler using @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<PojoErrorRestStudentResponse> handleException (ExceptionStudentNotFound exc){
			
			// create a ExceptionStudentNotFound class
			PojoErrorRestStudentResponse error = new PojoErrorRestStudentResponse();

			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		

		// Add another generic exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<PojoErrorRestStudentResponse> handleException (Exception exc){
			
			// create a ExceptionStudentNotFound class
					PojoErrorRestStudentResponse error = new PojoErrorRestStudentResponse();

					error.setStatus(HttpStatus.BAD_REQUEST.value());
					error.setMessage(exc.getMessage());
					error.setTimestamp(System.currentTimeMillis());
					
					// return ResponseEntity
					
					return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		

}
