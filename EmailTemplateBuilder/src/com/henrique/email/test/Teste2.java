package com.henrique.email.test;

import com.henrique.email.template.EmailTemplate;
import com.henrique.email.template.EmailTemplateBuilder;

public class Teste2 {

	
	public static void main(String[] args) {
		
		
		EmailTemplate email = new EmailTemplateBuilder()
				.addVariable("%USERNAME%", "Jon Snow")
				.addVariable("%REGISTRATION-TOKEN%", "430e842440a3f0989d")
				.setHeaderCharacters("##")
				.setSubjectProperty("subject:")
				.setSourceFileLocation("/tst/registration-template.txt")
				.createHtmlEmail();
		
		
		System.out.println("Html message: ");
		System.out.println(email.getMessage());
		
		System.out.println("Subject: " + email.getSubject());
	}
}
