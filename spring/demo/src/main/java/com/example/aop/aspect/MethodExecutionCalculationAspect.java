package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "com.example.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();
        long finishTime = System.currentTimeMillis();
        logger.info("Time taken by {}, is {}", joinPoint, finishTime-startTime);
    }


    /*
        this will only calculate the time with @TrackTime annotation that we have defined in our util class
        we are checking only for Dao1.retreiveSomething() method
     */

    @Around(value = "com.example.aop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public void afterReturningWithTrackingTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();
        long finishTime = System.currentTimeMillis();
        logger.info("Time taken by {}, is {}", joinPoint, finishTime-startTime);
    }

}
