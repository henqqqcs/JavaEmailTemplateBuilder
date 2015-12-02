package com.henrique.email.template;

import java.util.HashMap;
import java.util.Map;

public class EmailTemplate {

	private Map<String, String> variableMap = new HashMap<String, String>();
	private String sourceFileLocation;
	private String text;
	private String headerCharacters;
	private String subjectProperty;
	private String subject;

	public String getSubjectProperty() {
		return subjectProperty;
	}

	public void setSubjectProperty(String subjectProperty) {
		this.subjectProperty = subjectProperty;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHeaderCharacters() {
		return headerCharacters;
	}

	public void setHeaderCharacters(String headerCharacters) {
		this.headerCharacters = headerCharacters;
	}

	public String getSourceFileLocation() {
		return sourceFileLocation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setSourceFileLocation(String sourceFileLocation) {
		this.sourceFileLocation = sourceFileLocation;
	}

	public Map<String, String> getVariableMap() {
		return variableMap;
	}

	public void addVariable(String variable, String replace) {
		this.variableMap.put(variable, replace);
	}

}
