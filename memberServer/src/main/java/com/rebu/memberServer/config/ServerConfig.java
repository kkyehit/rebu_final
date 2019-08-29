package com.rebu.memberServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {
	 @Value("${example.property}")
	  private String exampleProperty;

	  public String getExampleProperty(){
		 
	    return exampleProperty;
	  }
}
