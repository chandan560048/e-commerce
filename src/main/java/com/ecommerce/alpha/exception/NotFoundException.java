package com.ecommerce.alpha.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

}
