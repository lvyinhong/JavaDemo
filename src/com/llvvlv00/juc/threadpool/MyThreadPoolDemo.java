package com.llvvlv00.juc.threadpool;

import java.util.concurrent.*;

/**
 * @author llvvlv00
 * @date 2021/02/28 10:04 下午
 * @since
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,5,1L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        try{
            // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                // 暂停一会儿线程
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
