package com.fix.SpringBootRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.fix.SpringBootRest.service.JobService.getJob(..)) && args(postId)")
    private Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {

        if (postId < 0){
            LOGGER.info("PostId is < 0");
            postId = -postId;
            LOGGER.info("New value of PostId is " + postId);
        }

        Object object = proceedingJoinPoint.proceed(new Object[]{postId});

        return object;
    }



}
