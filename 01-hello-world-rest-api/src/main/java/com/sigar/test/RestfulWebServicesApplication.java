package com.sigar.test;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

	  private final static Logger LOGGER = LoggerFactory.getLogger(RestfulWebServicesApplication.class);
	static
	{ 
		try
		{
			NativeUtils.loadLibraryFromJar("/lib/sigar-amd64-winnt.dll"); 
		}catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		

	    LOGGER.debug("This is a debug message");
	    LOGGER.info("This is an info message");
	    LOGGER.warn("This is a warn message");
	    LOGGER.error("This is an error message");
	 
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
}