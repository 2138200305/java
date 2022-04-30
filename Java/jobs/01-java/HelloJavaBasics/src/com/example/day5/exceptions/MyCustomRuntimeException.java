package com.example.day5.exceptions;

public class MyCustomRuntimeException extends RuntimeException {

	public MyCustomRuntimeException() {
	}
	
	public MyCustomRuntimeException(String message) {
		super(message);
	}
	
	public MyCustomRuntimeException(String message, Throwable clause) {
		super(message, clause);
	}
}
