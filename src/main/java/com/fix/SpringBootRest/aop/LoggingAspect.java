package com.fix.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.fix.SpringBootRest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called " + joinPoint.getSignature());
    }

    @After("execution(* com.fix.SpringBootRest.service.JobService.getJob(..))")
    public void logMethodCallExecuted(JoinPoint joinPoint){
        LOGGER.info("Method executed " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.fix.SpringBootRest.service.JobService.getJob(..))")
    public void logMethodCallCrash(JoinPoint joinPoint){
        LOGGER.info("Method has some issues " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.fix.SpringBootRest.service.JobService.getJob(..))")
    public void logMethodCallSuccess(JoinPoint joinPoint){
        LOGGER.info("Method executed successfully " + joinPoint.getSignature().getName());
    }

}
