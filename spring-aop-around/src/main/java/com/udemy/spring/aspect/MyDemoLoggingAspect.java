package com.udemy.spring.aspect;

import com.udemy.spring.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.udemy.spring.service.*.getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //print out method we're advising on.
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        //executing method.
        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - start;

        System.out.println("\n===>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.udemy.spring.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(pointcut="execution(* com.udemy.spring.dao.AccountDao.findAccounts(..))", throwing="exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exception) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + exception);

    }

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(pointcut="execution(* com.udemy.spring.dao.AccountDao.findAccounts(..))", returning="result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);
        // let's post-process the data ... let's modify it :-)
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>>> result is: " + result);
    }

    @Before("com.udemy.spring.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }
        }

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }
}










