package com.udemy.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.udemy.spring.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.udemy.spring.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.udemy.spring.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n\n@Before: calling method: " + method);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("\n\nARGUMENT: " + arg);
        }

    }

    @AfterReturning(pointcut="forAppFlow()", returning="result")
    public void afterReturning(JoinPoint theJoinPoint, Object result) {
        String method = theJoinPoint.getSignature().toShortString();
        logger.info("\n\n@AfterReturning: from method: " + method);
        logger.info("\n\nRESULT: " + result);
    }

}
