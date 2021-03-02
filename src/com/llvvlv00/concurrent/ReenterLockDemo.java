package com.llvvlv00.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lyh
 * @ClassName: lock
 * @description
 * @create 2021/02/26 - 17:23
 */

class Phone {
    private ReentrantLock lock = new ReentrantLock();

    public void sendSMS() throws Exception {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\tinvoked sendSMS()");
        sendEmail();
        lock.unlock();
    }

    public void sendEmail() throws Exception {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t####### invoked sendEmail()");
        lock.unlock();
    }
}
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        for (int i = 0; i < 100; i++) {
            new  Thread(()->{
                try {
                    phone.sendSMS();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            },"t"+i).start();
        }
    }
}
