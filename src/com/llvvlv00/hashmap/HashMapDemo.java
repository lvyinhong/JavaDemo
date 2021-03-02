package com.llvvlv00.hashmap;

import java.util.HashMap;

/**
 * @author lyh
 * @ClassName: HashMapDemo
 * @description
 * @create 2021/02/25 - 20:55
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("刘岩",18);
        hm.put("杨幂",28);
        hm.put("刘德华",40);
        hm.put("刘岩",20);
        System.out.println(hm);
    }
}
