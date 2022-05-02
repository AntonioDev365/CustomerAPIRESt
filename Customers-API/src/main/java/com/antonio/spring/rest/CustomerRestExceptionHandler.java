package com.antonio.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions 
//across the whole application in one global handling component. 
public class CustomerRestExceptionHandler {

	// add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler //this is the tipe of the response body
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex){
		
		// create CustomerErrorResponse
		 CustomerErrorResponse error = new CustomerErrorResponse( 
				 HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		// return ResponseEntity //body    //header
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler //this is the tipe of the response body
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex){
		
		// create CustomerErrorResponse
		 CustomerErrorResponse error = new CustomerErrorResponse( 
				 HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		// return ResponseEntity //body    //header
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
