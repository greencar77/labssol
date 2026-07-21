package com.example.iter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

//QULS
@Component
public class BeanA {
    private final Iterator<SomeService> services;

    @Autowired
    public BeanA(Iterator<SomeService> services) {
        this.services = services;
    }

    public void doSomething() {
        while (services.hasNext()) {
            System.out.println("BeanA is doing something with: " + services.next().getMessage());
        }
    }
}
