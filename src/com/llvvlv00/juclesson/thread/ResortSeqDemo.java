package com.llvvlv00.juclesson.thread;

public class ResortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            a+=5;
            System.out.println("****** 最终值a: "+ a);
        }
    }

    public static void main(String[] args) {
        ResortSeqDemo resortSeq = new ResortSeqDemo();
        new Thread(()->{resortSeq.method01();}, "ThreadA").start();
        new Thread(()->{resortSeq.method02();}, "ThreadB").start();
    }
}
