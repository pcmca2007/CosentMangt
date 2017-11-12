package com.org.cf.exception;



public class ConsentErrorResponse{
	
	private int errorCode;
	private String messageLink;
	
	public ConsentErrorResponse(){
		
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessageLink() {
		return messageLink;
	}
	public void setMessageLink(String messageLink) {
		this.messageLink = messageLink;
	}
	
	

}
