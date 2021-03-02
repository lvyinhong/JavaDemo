package com.llvvlv00.juc.volatile01;

/**
 * @author llvvlv00
 * @date 2021/02/22 8:08 下午
 * @since
 */
public class MyDataTest {
    public volatile int num = 0;

    public synchronized void addPlusPlus() {
        num++;
    }
}
