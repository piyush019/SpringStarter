package com.example.demo;

import com.example.demo.basic.BinarySearchImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class DemoApplicationWithoutSpringBootApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(DemoApplicationWithoutSpringBootApplication.class);
       try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplicationWithoutSpringBootApplication.class)) {
           BinarySearchImplementation implementation = context.getBean(BinarySearchImplementation.class);
//		BinarySearchImplementation implementation1 = context.getBean(BinarySearchImplementation.class);
           System.out.println(implementation);
//		System.out.println(implementation1);
           logger.info("{}", implementation);
           int result = implementation.binarySearch(3, Arrays.asList(1,2,3,4));
           System.out.println(result);
           logger.info("{}", result);
       };

    }
}
