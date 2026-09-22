package com.example.micrometer;

import io.micrometer.core.annotation.Timed;
import java.util.Random;

public class TimedService {

    private final Random random = new Random();

    @Timed(value = "service.slow.method", description = "A slow method that we want to time")
    public void slowMethod() throws InterruptedException {
        // Simulate some work
        Thread.sleep(random.nextInt(100) + 50);
    }

    @Timed(value = "service.fast.method", description = "A fast method that we want to time")
    public void fastMethod() throws InterruptedException {
        // Simulate some quick work
        Thread.sleep(random.nextInt(20) + 5);
    }
}
