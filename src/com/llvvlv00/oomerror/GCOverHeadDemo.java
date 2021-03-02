package com.llvvlv00.oomerror;

import com.llvvlv00.linkedlist.inter.List;

import java.util.ArrayList;

/**
 * @author llvvlv00
 * @date 2021/02/28 6:15 下午
 * @since
 */
public class GCOverHeadDemo {
    public static void main(String[] args) {
        int i = 0;
        ArrayList<String> list = new ArrayList<String>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e) {
            System.out.println("***********i="+i);
            e.printStackTrace();
            throw e;
        }

    }
}
