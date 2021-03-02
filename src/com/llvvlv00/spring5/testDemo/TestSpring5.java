package com.llvvlv00.spring5.testDemo;

import com.llvvlv00.spring5.Book;
import com.llvvlv00.spring5.MyBeanLife;
import com.llvvlv00.spring5.Orders;
import com.llvvlv00.spring5.User;
import com.llvvlv00.spring5.autowired.Emp;
import com.llvvlv00.spring5.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    public void testAdd() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean1.xml");
        // 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

    public void testBook1() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean1.xml");
        // 获取配置创建的对象
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);

        System.out.println(book1);
        System.out.println(book2);
    }

    public void testOrders1() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean1.xml");
        // 获取配置创建的对象
        Orders order = context.getBean("orders", Orders.class);

        System.out.println(order);
    }

    public void testBook2() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean1.xml");
        // 获取配置创建的对象
        Book book = context.getBean("book2", Book.class);

        System.out.println(book);
    }

    public void testUserServiceAdd()
    {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean1.xml");
        // 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    public void testMyBeanLife1()
    {
        // 加载spring的配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/bean2.xml");
        // 获取配置创建的对象
        MyBeanLife myBeanLife = context.getBean("myBeanLife", MyBeanLife.class);
        myBeanLife.setName("bacd");
        System.out.println("获取创建bean实例对象");
        System.out.println(myBeanLife);
        // 手动让bean实例销毁
        context.close();
    }

    public void testAutowired1() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/llvvlv00/spring5/autowired/bean3.xml");
        // 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }
}
