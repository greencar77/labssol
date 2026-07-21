package com.example.constr;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private BeanB beanB;

//    public BeanA() {}

    //With Spring 4.3+, if there's only one constructor, @Autowired is optional
    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }

    public void doSomething() {
        System.out.println("BeanA is doing something with: " + beanB.getMessage());
    }
}
