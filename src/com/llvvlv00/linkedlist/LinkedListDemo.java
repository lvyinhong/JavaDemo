package com.llvvlv00.linkedlist;


import com.llvvlv00.linkedlist.linked.LinkedList;

/**
 * @author lyh
 * @ClassName: LinkedListDemo
 * @description
 * @create 2021/02/26 - 11:11
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("=====初始化LinkedList:\t" + list);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println("=====添加数据:\t" + list);
        System.out.println("=====是否包含:\t" + list.contains(12));
        System.out.println("=====indexOf:\t" + list.indexOf(2));

        System.out.println("=====删除索引1的元素:\t value=" + list.remove(1)+",\tlist="+list);
    }
}
