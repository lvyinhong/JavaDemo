package com.llvvlv00.testReflect;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 反射创建类对象
        Class cla = Class.forName("com.llvvlv00.pojo.Person");
        Object obj = cla.newInstance();
    }
}
