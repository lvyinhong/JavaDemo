package com.llvvlv00.spring.junit;

import com.llvvlv00.spring.SpringDemoMain80;
import com.llvvlv00.spring.service.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lyh
 * @ClassName: TestAop
 * @description
 * @create 2021/02/27 - 17:45
 */
@SpringBootTest(classes = SpringDemoMain80.class)
@RunWith(SpringRunner.class)
public class TestAop {
    @Resource
    private CalcService calcService;

    @Test
    public void testAop4Ok() {
        System.out.println("spring 版本" + SpringVersion.getVersion() + "\t" + "springboot 版本: " + SpringBootVersion.getVersion());
        System.out.println("\t正常执行");
        calcService.div(10,2);
    }

    @Test
    public void testAopException() {
        System.out.println("spring 版本" + SpringVersion.getVersion() + "\t" + "springboot 版本: " + SpringBootVersion.getVersion());
        System.out.println("\t异常执行");
        calcService.div(10,0);
    }
}
