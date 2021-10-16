package com.example.demo.xml;

import com.example.demo.basic.BinarySearchImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlContextApplicationDemo {
    // this exercise is for how to use spring without annotation(java context) and with the help of xml
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(XmlContextApplicationDemo.class);
       try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"))
       {
           logger.info("loaded beans -> {}", (Object) context.getBeanDefinitionNames());
           XmlPersonDAO implementation = context.getBean(XmlPersonDAO.class);
           System.out.println(implementation);
           System.out.println(implementation.getXmlJdbcConnection());
       };

    }
}
