package com.llvvlv00.juc.volatile01;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author llvvlv00
 * @date 2021/02/22 7:03 下午
 * @since
 */

class MyData01 {
    public volatile int num = 0;
    public AtomicInteger number = new AtomicInteger();

    public void addPlusPlus() {
        num++;
        number.getAndIncrement();
    }

}

/**
 * 验证volatile不保证原子性
 * before: num有volatile修饰,20个线程每个线程执行1000次++; 期望结果是20000,结果总是少于期望值;
 * 原因: javap -C 包名:  字节码中 ++ 操作有3个指令
 * after: 解决方案
 * (1) addPlusPlus() 加synchronized(太重,不推荐)
 * (2) 使用atomic 包
 */
public class VolatileDemo {

    public static void main(String[] args) {
        // 原子性指的是什么意思？
        // 不可分割，完整性。
        // 某个线程正在执行某个具体业务时，中间不可以被加塞或分割，需要整体完整。
        // 要么同时成功，要么同时失败
        MyData01 myData01 = new MyData01();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j=1; j <= 1000; j++) {
                    myData01.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程全部计算完后，再用main线程取得最终的结果看是多少？
        while (Thread.activeCount() > 2) {
            // main 让出cpu
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finished num value=" + myData01.num);
        System.out.println(Thread.currentThread().getName() + "\t finished AtomicInteger number value=" + myData01.number);
    }
}
