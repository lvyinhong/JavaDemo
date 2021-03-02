package com.llvvlv00.spring4and5;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @ClassName: MyAspect
 * @description
 * @create 2021/02/27 - 16:25
 */
@EnableAspectJAutoProxy
@Component
public class MyAspect {
    public void beforeNotify() {
        System.out.println("========== @Before 我是前置通知");
    }

    public void afterNotify() {
        System.out.println("========== @Before 我司后置通知");
    }

    public void AfterReturning() {
        System.out.println("========== @AfterReturning 我司返回后通知");
    }

    public void AfterThrowing() {
        System.out.println("========== @AfterThrowing 我是异常通知");
    }


}
