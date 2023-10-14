package com.example.exceptions;

import java.util.UUID;

public class IncorrectPathException extends RuntimeException {
	
	private static final String UID = UUID.randomUUID().toString();
	private static final String UNABLE_TO_FIND_PATH = "UNABLE_TO_FIND_PROVIDED_PATH";
	
	String message;
	
	public IncorrectPathException() {
		this.message = "The path provided as the argument does not exist";
	}
	
	public IncorrectPathException(String message) {
		this.message = message;
	}
	
	public IncorrectPathException(String message, Throwable cause) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
