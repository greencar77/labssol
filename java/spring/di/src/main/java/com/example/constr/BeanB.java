package com.example.constr;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
    public String getMessage() {
        return "Hello from BeanB!";
    }
}
