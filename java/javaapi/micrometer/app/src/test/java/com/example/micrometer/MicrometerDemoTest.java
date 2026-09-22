package com.example.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MicrometerDemoTest {

    private TimedService service;
    private MeterRegistry registry;

    @BeforeEach
    void setUp() {
        MicrometerConfig config = new MicrometerConfig();
        registry = config.getRegistry();
        
        // In a real application (like Spring), the proxy is created automatically.
        // Here we manually create a proxy to apply the TimedAspect.
        AspectJProxyFactory factory = new AspectJProxyFactory(new TimedService());
        factory.addAspect(config.getTimedAspect());
        service = factory.getProxy();
    }

    @Test
    void testSlowMethodTiming() throws InterruptedException {
        int count = 3;
        for (int i = 0; i < count; i++) {
            service.slowMethod();
        }

        Timer timer = registry.find("service.slow.method").timer();
        
        assertEquals(count, timer.count(), "Should have recorded 3 calls");
        assertTrue(timer.totalTime(TimeUnit.MILLISECONDS) >= 150, "Total time should be at least 150ms");
        assertTrue(timer.max(TimeUnit.MILLISECONDS) >= 50, "Max time should be at least 50ms");
        
        System.out.println("[DEBUG_LOG] Slow method stats: count=" + timer.count() + 
                           ", total=" + timer.totalTime(TimeUnit.MILLISECONDS) + "ms" +
                           ", max=" + timer.max(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    void testFastMethodTiming() throws InterruptedException {
        int count = 5;
        for (int i = 0; i < count; i++) {
            service.fastMethod();
        }

        Timer timer = registry.find("service.fast.method").timer();
        
        assertEquals(count, timer.count(), "Should have recorded 5 calls");
        assertTrue(timer.totalTime(TimeUnit.MILLISECONDS) >= 25, "Total time should be at least 25ms");
        
        System.out.println("[DEBUG_LOG] Fast method stats: count=" + timer.count() + 
                           ", total=" + timer.totalTime(TimeUnit.MILLISECONDS) + "ms" +
                           ", max=" + timer.max(TimeUnit.MILLISECONDS) + "ms");
    }
}
