package com.llvvlv00.spring4and5;

import org.springframework.stereotype.Service;

/**
 * @author lyh
 * @ClassName: CalcServiceImpl
 * @description
 * @create 2021/02/27 - 16:22
 */

@Service
public class CalcServiceImpl implements CalService {

    @Override
    public int div(int x, int y){
        int result = x/y;
        System.out.println("=================CalcServiceImpl被调用了，计算结果result=\t" + result);
        return 0;
    }
}
