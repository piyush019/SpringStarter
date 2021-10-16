package com.example.demo;

import com.example.demo.componenetScan.ComponentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ComponentScanApplication {
    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(ComponentScanApplication.class);
//        ApplicationContext applicationContext = SpringApplication.run(ComponentScanApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanApplication.class);
        ComponentDao componentDao = applicationContext.getBean(ComponentDao.class);

        System.out.println(componentDao);

        LOGGER.info("{}", componentDao);


    }
}
