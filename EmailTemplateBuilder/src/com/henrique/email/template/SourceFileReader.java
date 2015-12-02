package com.henrique.email.template;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.henrique.email.exceptions.EmailTemplateNotFoundException;

public class SourceFileReader {


	public String getFileText(String path) throws EmailTemplateNotFoundException {

		try {
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder out = new StringBuilder();
			String line;
			String lineSepator = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				line = line + lineSepator;
				out.append(line);
			}
			reader.close();
			inputStream.close();
			
			return out.toString();
			
		} catch (Exception e) {
			throw new EmailTemplateNotFoundException();
		}
		
	}

}
