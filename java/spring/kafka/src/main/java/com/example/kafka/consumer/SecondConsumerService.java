package com.example.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.kafka.KafkaTopicConfig.TOPIC;

@Service
public class SecondConsumerService { //QSNB

    private static final Logger logger = LoggerFactory.getLogger(SecondConsumerService.class);

    @KafkaListener(topics = TOPIC, groupId = "demo-group2")
    public void consume(String message) {
        logger.info("Consumed message: {}", message);
    }
}
