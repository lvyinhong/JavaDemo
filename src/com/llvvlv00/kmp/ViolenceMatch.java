package com.llvvlv00.kmp;

/**
 * @author llvvlv00
 * @date 2021/03/01 12:03 上午
 * @since
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        // 测试暴力匹配算法
        String str1 = "ABAABCABCDABCDEA";
        String str2 = "ABCD";
        System.out.println("index =" + violenceMatch(str1, str1));
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;
        int i =0, // i索引指向s1
                j=0; // j索引指向s2
        while(i < s1Len && j <s2Len) {
            // 保证匹配时，不越界
            if(s1[i] == s2[j]) { //匹配ok
                i++;
                j++;
            }else { //没有匹配成功
                i = i-(j-1);
                j = 0;
            }
        }
        // 判断是否匹配成功
        if(j == s2Len) {
            return i -j;
        }else {
            return -1;
        }
    }
}
