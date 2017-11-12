package com.org.cf.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ConsentErrorResponse> exceptionHandler(Exception ex) {
		ConsentErrorResponse error = new ConsentErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		error.setMessageLink("ConsentConfirmationLink");
		return new ResponseEntity<ConsentErrorResponse>(error, HttpStatus.OK);
	}
	
	

}
