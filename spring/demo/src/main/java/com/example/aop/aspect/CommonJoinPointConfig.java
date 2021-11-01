package com.example.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.example.aop.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.example.aop.business.*.*(..))")
    public void businessLayerExecution(){}

    //other ways to define pointcut as well
    @Pointcut("com.example.aop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.example.aop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void allLayerExecution(){}

    @Pointcut("bean(*dao*)") //any beans that has dao in their name
    public void beanContainingDao(){}

    @Pointcut("@annotation(com.example.util.TrackTime)")
    public void trackTimeAnnotation(){}
}
