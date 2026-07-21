package com.example.coll;

import org.springframework.stereotype.Component;

@Component
public class BeanC implements SomeService {
    @Override
    public String getMessage() {
        return "Hello from BeanC!";
    }
}
