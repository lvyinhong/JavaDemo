package com.llvvlv00.spring.service.impl;

/**
 * @author lyh
 * @ClassName: circDependence
 * @description
 * @create 2021/02/27 - 19:46
 */

/**
 * Spring 循环依赖演示
 */
public class CircularDependence {
    class A {
        B b;
    }
    class B {
        C c;
    }
    class C {
        A a;
    }
}
