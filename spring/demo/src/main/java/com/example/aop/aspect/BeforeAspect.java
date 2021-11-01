package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// define Aop related configuration and Configuration
@Aspect
@Configuration
public class BeforeAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What methods to call
    // in theory the freamework who does all the things related to Aop is called weaving and weaver
    @Before("execution(* com.example.aop.business.*.*(..))") // it's called pointcut
    public void before(JoinPoint joinPoint){

        // below line of code is called Advice
        logger.info("intercepted method call - {}", joinPoint);
    }
}
