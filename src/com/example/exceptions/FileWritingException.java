package com.example.exceptions;

import java.util.UUID;

public class FileWritingException extends RuntimeException {
	private static final String UID = UUID.randomUUID().toString();
	
	String message;
	
	public FileWritingException() {
		this.message = "There was a problem while writing the file";
	}
	
	public FileWritingException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
