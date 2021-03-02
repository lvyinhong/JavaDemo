package com.llvvlv00.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lyh
 * @ClassName: LockSupportDemo
 * @description
 * @create 2021/02/26 - 18:46
 */
public class LockSupportDemo {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
      Thread a = new Thread(() -> {
          System.out.println(Thread.currentThread().getName() + "\t"+"------ come in");
          LockSupport.park(); //被阻塞...等待通知放行，它通过需要许可证
          LockSupport.park(); //被阻塞...等待通知放行，它通过需要许可证
          System.out.println(Thread.currentThread().getName() + "\t"+"------ 被唤醒");
      },"a");
      a.start();

      // 暂停几秒钟线程
      try {TimeUnit.SECONDS.sleep(3);}catch (InterruptedException  e) {e.printStackTrace();}
      Thread b = new Thread(()->{
          LockSupport.unpark(a); // 唤醒a线程
          LockSupport.unpark(a); // 唤醒a线程
          System.out.println(Thread.currentThread().getName() + "\t"+"------ 通知了");
      },"b");
      b.start();
    }
}
