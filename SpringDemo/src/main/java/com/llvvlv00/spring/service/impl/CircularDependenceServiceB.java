package com.llvvlv00.spring.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @ClassName: CircularDependenceServiceB
 * @description
 * @create 2021/02/27 - 20:04
 */
@Component
public class CircularDependenceServiceB {
    private CircularDependenceServiceA serviceA;

    public CircularDependenceServiceB(CircularDependenceServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public CircularDependenceServiceB() {
        System.out.println("=============ServiceB 创建成功");
    }

    public CircularDependenceServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(CircularDependenceServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
