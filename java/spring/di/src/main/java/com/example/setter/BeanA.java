package com.example.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private BeanB beanB;

    public BeanA() {
    }

    @Autowired
    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }
//
//    @Autowired
//    public void something(BeanB beanB) {
//        this.beanB = beanB;
//    }

    public void doSomething() {
        System.out.println("BeanA is doing something with: " + beanB.getMessage());
    }
}
