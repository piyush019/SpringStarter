package com.example.demo.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SomeExternalApplicationDemo {
    // this exercise is for how to read values from application.properties
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SomeExternalApplicationDemo.class);
       try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SomeExternalApplicationDemo.class))
       {
           SomeExternalService someExternalService = context.getBean(SomeExternalService.class);
//           logger.info("loaded beans -> {}", (Object) context.getBeanDefinitionNames());
           System.out.println(someExternalService);
           System.out.println(someExternalService.getUrl());
       };

    }
}
