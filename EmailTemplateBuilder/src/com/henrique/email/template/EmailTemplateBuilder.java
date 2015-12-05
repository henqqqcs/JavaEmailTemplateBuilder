package com.henrique.email.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.henrique.email.template.io.EmailSourceFileReader;

public class EmailTemplateBuilder {

	private Map<String, String> variableMap = new HashMap<String, String>();
	private String headerCharacters;
	private String subject;
	private String subjectProperty;
	private String htmlMessage;

	public EmailTemplateBuilder addVariable(String variable, String replace) {
		variableMap.put(variable, replace);
		return this;
	}

	public EmailTemplateBuilder setHeaderCharacters(String headerCharacters) {
		this.headerCharacters = headerCharacters;
		return this;
	}

	public EmailTemplateBuilder setSourceFileLocation(String sourceFileLocation) {
		try {
			this.htmlMessage = new EmailSourceFileReader().getFileString(sourceFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public EmailTemplateBuilder setHtmlMessage(String htmlMessage) {
		this.htmlMessage = "Hello %USERNAME%, Welcome to the Java Email Template API forums!";
		return this;
	}

	public EmailTemplateBuilder setSubjectProperty(String subjectProperty) {
		this.subjectProperty = subjectProperty;
		return this;
	}

	public EmailTemplate createHtmlEmail() {

		if (htmlMessage == null) {
			throw new IllegalArgumentException(
					"The variable htmlMessage is null. You should set it using the method setSourceFileLocation() or setHtmlMessage().");
		}

		// replace variables
		replaceVariables();

		// get the subject if its setted
		extractSubject();

		// remove header
		removeHeader();

		// create email
		EmailTemplate email = new EmailTemplate();
		email.setMessage(htmlMessage);
		email.setSubject(subject);
		return email;

	}

	private void removeHeader() {

		// no headers setted
		if (headerCharacters == null) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new StringReader(htmlMessage))) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith(headerCharacters)) {
					sb.append(line + System.getProperty("line.separator"));
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.htmlMessage = sb.toString();
	}

	private void replaceVariables() {
		// iterate map of variables
		for (Map.Entry<String, String> entry : variableMap.entrySet()) {
			htmlMessage = htmlMessage.replace(entry.getKey(), entry.getValue());
		}

	}

	private void extractSubject() {

		if (subjectProperty != null) {

			try (BufferedReader reader = new BufferedReader(new StringReader(htmlMessage))) {
				String line = reader.readLine();
				while (line != null) {
					if (line.contains(subjectProperty)) {
						int indexOf = line.indexOf(subjectProperty);
						int propLenght = subjectProperty.length();
						this.subject = line.substring(indexOf + propLenght).trim();
					}
					line = reader.readLine();
				}

				if (subject == null) {
					throw new IllegalArgumentException(
							"Could not found this property on source file: " + subjectProperty);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return;

	}

}
