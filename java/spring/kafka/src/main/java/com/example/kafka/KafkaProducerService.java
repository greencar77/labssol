package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@EnableScheduling
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "demo-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        String message = "Message generated at " + System.currentTimeMillis() + " with UUID: " + UUID.randomUUID();
        logger.info("Producing message: {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
