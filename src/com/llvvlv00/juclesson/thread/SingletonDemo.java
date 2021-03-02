package com.llvvlv00.juclesson.thread;

public class SingletonDemo {
    /*
        private static SingletonDemo instance = null;
    */

    private volatile static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t SingletonDemo构造方法执行了");
    }

    public static SingletonDemo getInstance() {
       if (instance == null) {
           synchronized (SingletonDemo.class) {
               if (instance == null) {
                   instance = new SingletonDemo();
               }
           }
       }
    /*
        if (instance == null) {
            instance = new SingletonDemo();
        }
    */
        return instance;
    }

    public static void main(String[] args) {
    /*
        // main 操作
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    */

        // 多线程操作
        for (int i=0; i <10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
