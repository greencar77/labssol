package com.example.coll;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanA {
    private final List<SomeService> services;

    public BeanA(List<SomeService> services) {
        this.services = services;
    }

    public void doSomething() {
        for (SomeService s: services) {
            System.out.println("BeanA is doing something with: " + s.getMessage());
        }
    }
}
