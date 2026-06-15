package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.kafka.KafkaTopicConfig.DEMO_TOPIC;

@Service
@EnableScheduling
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        String message = "Message generated at " + System.currentTimeMillis() + " with UUID: " + UUID.randomUUID();
        logger.info("Producing message: {}", message);
        this.kafkaTemplate.send(DEMO_TOPIC, message);
    }
}
