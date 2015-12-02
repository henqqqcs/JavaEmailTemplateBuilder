package com.henrique.email.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.henrique.email.exceptions.EmailTemplateNotFoundException;
import com.henrique.email.exceptions.SubjectPropertyNotFoundException;

public class EmailTemplateBuilder {

	private EmailTemplate emailTemplateInstance = new EmailTemplate();

	public EmailTemplateBuilder addVariable(String variable, String replace) {
		// add a variable
		this.emailTemplateInstance.addVariable(variable, replace);
		return this;
	}

	public EmailTemplateBuilder setHeaderCharacters(String headerCharacters) {
		this.emailTemplateInstance.setHeaderCharacters(headerCharacters);
		return this;
	}

	public EmailTemplateBuilder setSourceFileLocation(String sourceFileLocation) {

		try {
			this.emailTemplateInstance.setSourceFileLocation(sourceFileLocation);
			String templateText;
			templateText = new SourceFileReader().getFileText(sourceFileLocation);
			this.emailTemplateInstance.setText(templateText);
		} catch (EmailTemplateNotFoundException e) {
			e.printStackTrace();
		}
		return this;
	}

	public EmailTemplate createTemplate() {

		//check if has a subject, must be before the header removal
		if (emailTemplateInstance.getSubjectProperty() != null) 
			extractSubject();
			
		// check if has a header
		if (emailTemplateInstance.getHeaderCharacters() != null) {
			removeHeader();
		}
		
		replaceVariables();
		return emailTemplateInstance;
	}

	private void extractSubject() {
		
		String emailTemplateText = this.emailTemplateInstance.getText();
		
		try (BufferedReader reader = new BufferedReader(new StringReader(emailTemplateText))) {
			String line = reader.readLine();
			while (line != null) {
				if (line.contains(emailTemplateInstance.getSubjectProperty())) {
					int indexOf = line.indexOf(emailTemplateInstance.getSubjectProperty());
					int propLenght = emailTemplateInstance.getSubjectProperty().length();
					String subject = line.substring(indexOf + propLenght);
					emailTemplateInstance.setSubject(subject.trim());
				}
				line = reader.readLine();
			}
			
			if (emailTemplateInstance.getSubject() == null) {
				throw new SubjectPropertyNotFoundException("Could not found this property on source file: " + emailTemplateInstance.getSubjectProperty());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;
		
	}

	private void removeHeader() {

		String emailTemplateText = this.emailTemplateInstance.getText();

		List<String> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new StringReader(emailTemplateText))) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith(emailTemplateInstance.getHeaderCharacters())){
					result.add(line);
				}
				line = reader.readLine();
			}
		} catch (IOException exc) {
		}
		
		//set new text without the header
		StringBuilder sb = new StringBuilder();
		for (String line : result) {
			sb.append(line + System.getProperty("line.separator"));
		}
		emailTemplateInstance.setText(sb.toString());
	}

	private void replaceVariables() {

		String emailTemplateText = this.emailTemplateInstance.getText();
		if (emailTemplateText != null) {
			// iterate map of variables
			Map<String, String> variableMap = this.emailTemplateInstance.getVariableMap();
			for (Map.Entry<String, String> entry : variableMap.entrySet()) {
				emailTemplateText = emailTemplateText.replace(entry.getKey(), entry.getValue());
			}
			this.emailTemplateInstance.setText(emailTemplateText);

		} else {

		}
	}

	public EmailTemplateBuilder setSubjectProperty(String subjectProperty) {
		this.emailTemplateInstance.setSubjectProperty(subjectProperty);
		return this;
	}

}
