package com.henrique.email.template.io;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class EmailSourceFileReader {

	public String getFileString(String path) throws IOException {

		try {
			InputStream in = EmailSourceFileReader.class.getResourceAsStream(path);
			return IOUtils.toString(in);
		} catch (Exception e) {
			throw new IOException("Error while opening the file: " + path);
		}
	}

}
