package com.llvvlv00.juclesson.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatitleDemo {
    public static void main(String[] args) {
//        volatitleVisibilityDemo();
        atomicDemo();
    }

    /**
     * volatitle 可以保证可见性，及时通知其他线程主物理内存的值已经被修改
     */
    private static void volatitleVisibilityDemo() {
        System.out.println("可见性测试");
        MyData myData = new MyData(); //资源类

        // 启动一个线程操作共享数据
        new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"\t 执行");

           try {
               TimeUnit.SECONDS.sleep(3);
           }catch (InterruptedException e) {
               e.printStackTrace();
           }
           myData.setTo60();
           System.out.println(Thread.currentThread().getName()+"\t 更新number的值"+ myData.number);

        },"ThreadA").start();
        while (myData.number == 0) {
            // main线程持有共享数据的拷贝，一直为0
            // println() 有synchronized 将线程内部数据拷贝的共享内存
//            System.out.println(Thread.currentThread().getName()+"\t 等待");
        }
        System.out.println(Thread.currentThread().getName() + "\t main获取number值"+ myData.number);

    }

    private static void atomicDemo()
    {
        System.out.println("原子性测试");
        MyData myData = new MyData();
        for (int i=1; i<=20; i++) {
            new Thread(()->{
                for (int j=0; j <1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int类型,最终number的值: "+myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger类型,最终number的值: "+myData.atomicInteger);
    }
}

class MyData {
//    int number = 0;
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();


    public void setTo60() {
        this.number = 60;
    }

    // 此时 number 前面已经加了volatitle 但不能保证原子性
//    public synchronized void addPlusPlus()  {
    public void addPlusPlus()  {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
