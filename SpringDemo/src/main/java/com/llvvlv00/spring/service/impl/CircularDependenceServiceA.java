package com.llvvlv00.spring.service.impl;

import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @ClassName: CirclarDependenceServiceA
 * @description
 * @create 2021/02/27 - 20:04
 */
@Component
public class CircularDependenceServiceA {
    private CircularDependenceServiceB serviceB;

    public CircularDependenceServiceA(CircularDependenceServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public CircularDependenceServiceA() {
        System.out.println("=============ServiceA 创建成功");
    }

    public CircularDependenceServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(CircularDependenceServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
