package com.example.demo.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		 Logger logger = LoggerFactory.getLogger(DemoApplication.class);
		ApplicationContext context = SpringApplication.run(DemoApplication.class,args);
		BinarySearchImplementation implementation = context.getBean(BinarySearchImplementation.class);
		logger.info("{}", implementation);
		int result = implementation.binarySearch(3, Arrays.asList(1,2,3,4));
		logger.info("{}", result);
	}

}
