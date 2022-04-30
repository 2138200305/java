package com.example.day5.exceptions;

public class MyCustomException extends Exception {
	public MyCustomException() {
	}
	
	public MyCustomException(String message) {
		super(message);
	}
	
	public MyCustomException(String message, Throwable clause) {
		super(message, clause);
	}
}
