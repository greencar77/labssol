package com.example.iter;

import org.springframework.stereotype.Component;

@Component
public class BeanB implements SomeService {
    @Override
    public String getMessage() {
        return "Hello from BeanB!";
    }
}
