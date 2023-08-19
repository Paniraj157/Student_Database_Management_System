package com.jspiders;

public class invalidChoiceException extends RuntimeException {
	private String message;

	public invalidChoiceException(String message) {
		this.message = message;
	
	}

	@Override
	public String getMessage() {
		return message;
	}
	

}
