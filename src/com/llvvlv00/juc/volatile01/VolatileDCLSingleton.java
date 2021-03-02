package com.llvvlv00.juc.volatile01;

/**
 * @author llvvlv00
 * @date 2021/02/22 9:21 下午
 * @since
 */
public class VolatileDCLSingleton {
    private static VolatileDCLSingleton instance;

    private VolatileDCLSingleton() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法 VolatileDCLSingleton()");
    }

    public static VolatileDCLSingleton getInstance() {
        if (null == instance) {
            synchronized (VolatileDCLSingleton.class) {
                if (null == instance ) {
                    instance = new VolatileDCLSingleton();
                }
            }
        }
        return instance;
    }
}
