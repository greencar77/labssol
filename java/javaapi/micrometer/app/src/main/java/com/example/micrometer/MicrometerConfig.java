package com.example.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.core.aop.TimedAspect;

public class MicrometerConfig {

    private final MeterRegistry registry;
    private final TimedAspect timedAspect;

    public MicrometerConfig() {
        // SimpleMeterRegistry is useful for testing or local development
        this.registry = new SimpleMeterRegistry();
        // TimedAspect is required to process the @Timed annotation
        this.timedAspect = new TimedAspect(registry);
    }

    public MeterRegistry getRegistry() {
        return registry;
    }

    public TimedAspect getTimedAspect() {
        return timedAspect;
    }
}
