package com.henrique.email.test;

import com.henrique.email.template.EmailTemplate;
import com.henrique.email.template.EmailTemplateBuilder;

public class Test {

	public static void main(String[] args) {

		EmailTemplate emailTemplate = new EmailTemplateBuilder()
				.addVariable("%USERNAME%", "henrique")
				.addVariable("%REGISTRATION-TOKEN%", "430e842440a3f0989d")
				.setHeaderCharacters("##")
				.setSubjectProperty("subject:")
				.setSourceFileLocation("resources/emails/registration-template.txt").createTemplate();

		System.out.println("Result: ");
		System.out.println("Subject: " + emailTemplate.getSubject());
		System.out.println(emailTemplate.getText());

	}
}
