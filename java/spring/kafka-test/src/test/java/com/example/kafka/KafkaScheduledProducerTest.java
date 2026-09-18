package com.example.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaScheduledProducerTest {

    @Mock
    private KafkaProducer kafkaProducer;

    @InjectMocks
    private KafkaScheduledProducer kafkaScheduledProducer;

    @Test
    public void testScheduleMessage() {
        kafkaScheduledProducer.scheduleMessage();
        verify(kafkaProducer).sendMessage(eq("test-topic"), anyString());
    }
}
