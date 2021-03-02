package com.llvvlv00.kmp;

import java.util.Arrays;

/**
 * @author llvvlv00
 * @date 2021/03/01 12:42 上午
 * @since
 */
public class KmpAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);
        System.out.println("next = " + Arrays.toString(next));
        System.out.println("kmpSearch(str1, str2, next) = " + kmpSearch(str1, str2, next));
    }

    /**
     *
     * @param str1 主串
     * @param str2 模式串
     * @param next 模式串对应的部分匹配表
     * @return -1没有匹配到，否则第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        // 遍历
        for(int i=0,j = 0; i<str1.length();i++) {
            // 当dest.charAt(i) != dest.charAt(j),我们需要next[j-1]获取新的j,
            // 直到 dest.charAt(i) == dest.charAt(j)成立才退出
            // KMP算法核心点
            while ( j>0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) { //找到了
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 获取到一个字符串(子串)的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串dest长度为1 部分匹配值就是0
        for(int i=1,j=0; i<dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j),我们需要next[j-1]获取新的j,
            // 直到 dest.charAt(i) == dest.charAt(j)成立才退出
            // 这是kmp算法的核心点
            while ( j>0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            // 当 dest.charAt(i) == dest.charAt(j) 这个条件满足时，部分匹配值就+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
