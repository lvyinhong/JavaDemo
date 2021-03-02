package com.llvvlv00.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @ClassName: MyAspect
 * @description
 * @create 2021/02/27 - 16:54
 */
@Aspect
@Component
public class MyAspect {

    @Before("execution(public int com.llvvlv00.spring.service.impl.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("========== @Before 我是前置通知");
    }

    @After("execution(public int com.llvvlv00.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("========== @After 我是后置通知");
    }

    @AfterReturning("execution(public int com.llvvlv00.spring.service.impl.CalcServiceImpl.*(..))")
    public void AfterReturning() {
        System.out.println("========== @AfterReturning 我是返回后通知");
    }

    @AfterThrowing("execution(public int com.llvvlv00.spring.service.impl.CalcServiceImpl.*(..))")
    public void AfterThrowing() {
        System.out.println("========== @AfterThrowing 我是异常通知");
    }

    @Around("execution(public int com.llvvlv00.spring.service.impl.CalcServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        Object retValue = null;
        System.out.println("我是环绕通知@Around之前AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知@Around之后BBB");
        return retValue;
    }
}
