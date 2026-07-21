package com.example.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    @Autowired
    private BeanB beanB;

    public BeanA() {}

    public void doSomething() {
        System.out.println("BeanA is doing something with: " + beanB.getMessage());
    }
}
