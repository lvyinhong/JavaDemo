package com.llvvlv00.oomerror;

/**
 * @author llvvlv00
 * @date 2021/02/28 5:47 下午
 * @since
 */
public class StackOverFlowerDemo {
    public static void main(String[] args) {
        stackOverflowError(); //Exception in thread "main" java.lang.StackOverflowError
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
