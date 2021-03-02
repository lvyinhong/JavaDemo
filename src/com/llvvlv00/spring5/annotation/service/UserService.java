package com.llvvlv00.spring5.annotation.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public void add() {
        System.out.println("Service add ...");
    }
}
