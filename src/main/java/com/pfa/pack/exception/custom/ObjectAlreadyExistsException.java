package com.pfa.pack.exception.custom;

public class ObjectAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ObjectAlreadyExistsException() {
		super();
	}
	
	public ObjectAlreadyExistsException(String message) {
		super(message);
	}
	
	public ObjectAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
	public ObjectAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	
}




