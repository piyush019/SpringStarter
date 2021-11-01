package com.example.aop;

import com.example.aop.business.Business1;
import com.example.aop.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {
    /* using command line runner we can get rid of adding everything in static method
            and we can use run method and use autowire and stuff
       So, as soon as springApplication.run is called override run method will get call as well
     */

    private Logger logger = LoggerFactory.getLogger(AopApplication.class);

    @Autowired
    Business1 business1;

    @Autowired
    Business2 business2;

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info((String) business1.calculateSomething());
        logger.info(business2.calculateSomething());
    }
}
