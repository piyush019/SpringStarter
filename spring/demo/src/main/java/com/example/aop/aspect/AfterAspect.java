package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /* @AfterReturning can be use when there is no exception involved meaning that it will only gets executed when application is succeeded
        for example let say Business1.calculateSomething throw exception then the output/log will be something like this
         "execution(String com.example.aop.business.Business2.calculateSomething()) returned with value Dao2"
         only successful method is getting executed
     */

    @AfterReturning(
            value = "execution(* com.example.aop.business.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("{} returned with value {}", joinPoint, result);
    }

    /*
        @AfterThrowing only gets executed when there are some of the methods throws exception
        so if take the above example when Business1.calculateSomething throw exception then the output/log will be something like this
        execution(Object com.example.aop.business.Business1.calculateSomething()) returned with value {}
        java.lang.Exception: Exception thrown
     */
    @AfterThrowing(
            value = "execution(* com.example.aop.business.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Object exception){
        logger.info("{} returned with value {}", joinPoint, exception);
    }

    // @After can be called everytime means it doesn't matter if the method is returning exception or not
    @After("execution(* com.example.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint){
        logger.info("{} returned", joinPoint);
    }
}
