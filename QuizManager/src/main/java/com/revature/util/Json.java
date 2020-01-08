/**
 * author: Kamilah Carlisle
 * date due: Jan 6, 2020
 * description: this class defines how an object mapper will behave when reading a request
 * and returning a response
 */

package com.revature.util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {
	
	// For readability/maintainability
	public static final String CONTENT_TYPE = "application/json";
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	// invoke <clinit> (don't have to do this, I like the pretty print)
	static {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	// Restrict Instantiation
	private Json() {}
	
	//Object is being converted into JSON
	public static byte[] write(Object o) {
		try {
			return mapper.writeValueAsBytes(o);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	//Object is being read, the class type remains generic here and can be specified
	//in dispatcher 
	public static Object read(InputStream input, Class<?> clazz) {
		try {
			return mapper.readValue(input, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}