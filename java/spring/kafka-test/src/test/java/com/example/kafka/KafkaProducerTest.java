package com.example.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaProducer kafkaProducer;

    @Test
    public void testSendMessage() {
        String topic = "test-topic";
        String message = "Hello Kafka!";

        kafkaProducer.sendMessage(topic, message);

        verify(kafkaTemplate).send(topic, message);
    }

    @Test
    public void testSendThreeMessages() {
        String topic = "multiple-topic";
        String message1 = "Message 1";
        String message2 = "Message 2";
        String message3 = "Message 3";

        kafkaProducer.sendMessage(topic, message1);
        kafkaProducer.sendMessage(topic, message2);
        kafkaProducer.sendMessage(topic, message3);

        verify(kafkaTemplate).send(topic, message1);
        verify(kafkaTemplate).send(topic, message2);
        verify(kafkaTemplate).send(topic, message3);
    }
}
