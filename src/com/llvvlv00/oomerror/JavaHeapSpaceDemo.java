package com.llvvlv00.oomerror;


/**
 * @author llvvlv00
 * @date 2021/02/28 5:54 下午
 * @since
 * JVM 配置参数演示
 * -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[80 * 1024 *1024];
    }
}
