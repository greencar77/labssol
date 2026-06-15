package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SecondConsumerService { //QSNB

    private static final Logger logger = LoggerFactory.getLogger(SecondConsumerService.class);

    @KafkaListener(topics = "demo-topic", groupId = "demo-group2")
    public void consume(String message) {
        logger.info("Consumed message: {}", message);
    }
}
