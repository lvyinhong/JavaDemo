package com.llvvlv00.spring5;

public class MyBeanLife {
    private String name;

    public MyBeanLife() {
        System.out.println("执行无参构造方法创建bean实例");
    }

    public void setName(String name) {
        System.out.println("执行set方法设置属性值");
        this.name = name;
    }

    public void initMethod() {
        System.out.println("执行了初始化方法");
    }

    public void destroyMethod() {
        System.out.println("执行销毁的方法");
    }

}
