package com.example.kafka;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaScheduledProducer {

    private final KafkaProducer kafkaProducer;

    public KafkaScheduledProducer(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleMessage() {
        String message = "Scheduled message at " + LocalDateTime.now();
        kafkaProducer.sendMessage("test-topic", message);
    }
}
