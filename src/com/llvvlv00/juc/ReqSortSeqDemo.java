package com.llvvlv00.juc;

/**
 * @author llvvlv00
 * @date 2021/02/22 9:01 下午
 * @since
 */
public class ReqSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;          // 语句1
        flag = true;    // 语句2
    }

    public void method02() {
        if (flag) {
            a = a +5; //语句3
            System.out.println("*********retValue=" + a);
        }
    }
}
