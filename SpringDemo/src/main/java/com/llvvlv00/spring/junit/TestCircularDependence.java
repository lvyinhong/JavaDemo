package com.llvvlv00.spring.junit;

import com.llvvlv00.spring.service.impl.CircularDependenceServiceA;
import com.llvvlv00.spring.service.impl.CircularDependenceServiceB;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lyh
 * @ClassName: TestCircularDependence
 * @description
 * @create 2021/02/27 - 20:09
 */
public class TestCircularDependence {

    /**
     * 构造方法无法解决循环依赖
     */
    @Test
    public void testCircularDependenceConstructor() {
//        new CircularDependenceServiceA(new CircularDependenceServiceB(new CircularDependenceServiceA())); //??循环到死
    }

    @Test
    public void testSetterInjection() {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
            context.getBean("a", CircularDependenceServiceA.class);
            context.getBean("b", CircularDependenceServiceB.class);
    }
}
