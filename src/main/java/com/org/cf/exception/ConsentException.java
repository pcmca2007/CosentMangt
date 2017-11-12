package com.org.cf.exception;

public class ConsentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034395805318812779L;
	
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ConsentException(String errorMessage){
		super(errorMessage);
		this.errorMessage=errorMessage;
	}
	
	public ConsentException(){
		
		super();
	}

}
