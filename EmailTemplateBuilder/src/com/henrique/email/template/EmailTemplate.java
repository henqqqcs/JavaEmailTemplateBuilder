package com.henrique.email.template;

public class EmailTemplate {

	protected EmailTemplate (){
	}
	
	private String message;
	private String subject;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
