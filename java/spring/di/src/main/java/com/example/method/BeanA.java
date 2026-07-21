package com.example.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private BeanB beanB;
    private BeanC beanC;

    public BeanA() {
    }

    @Autowired
    public void something(BeanB beanB, BeanC beanC) {
        this.beanB = beanB;
        this.beanC = beanC;
    }

    public void doSomething() {
        System.out.println("BeanA is doing something with: " + beanB.getMessage());
        System.out.println("BeanA is doing something with: " + beanC.getMessage());
    }
}
