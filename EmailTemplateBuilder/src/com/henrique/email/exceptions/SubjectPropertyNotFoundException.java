package com.henrique.email.exceptions;

public class SubjectPropertyNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public SubjectPropertyNotFoundException() {
	}
	
	public SubjectPropertyNotFoundException(String message) {
		super(message);
	}
}
