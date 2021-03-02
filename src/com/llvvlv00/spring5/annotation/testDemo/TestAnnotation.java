package com.llvvlv00.spring5.annotation.testDemo;

import com.llvvlv00.spring5.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public void testService() {
        ApplicationContext context =
                new  ClassPathXmlApplicationContext("com/llvvlv00/spring5/annotation/bean5.xml");
        UserService userService =  context.getBean("userService", UserService.class);
        userService.add();
    }
}
