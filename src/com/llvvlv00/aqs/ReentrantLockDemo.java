package com.llvvlv00.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lyh
 * @ClassName: ReentrantLock
 * @description
 * @create 2021/02/26 - 21:06
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(()-> {
            lock.lock();
            try {
                System.out.println("-----"+ Thread.currentThread().getName() +" thread come in");
                   try { TimeUnit.MINUTES.sleep(20); }catch (InterruptedException e) {e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(()-> {
            lock.lock();
            try {
                System.out.println("-----"+ Thread.currentThread().getName() +" thread come in");
                try { TimeUnit.MINUTES.sleep(20); }catch (InterruptedException e) {e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        }, "B").start();

        new Thread(()-> {
            lock.lock();
            try {
                System.out.println("-----"+ Thread.currentThread().getName() +" thread come in");
                try { TimeUnit.MINUTES.sleep(20); }catch (InterruptedException e) {e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
