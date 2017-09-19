package com.superhope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SuperHopeStart {

	  
	  public static void main( String args[] ){
		  ApplicationContext ctx = SpringApplication.run(SuperHopeStart.class, args);
	  }
	  
}
