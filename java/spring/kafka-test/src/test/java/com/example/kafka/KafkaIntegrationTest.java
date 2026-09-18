package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"test-topic"}, bootstrapServersProperty = "spring.kafka.bootstrap-servers")
public class KafkaIntegrationTest {

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private TestConsumer consumer;

    @TestConfiguration
    static class Config {
        @Bean
        public TestConsumer testConsumer() {
            return new TestConsumer();
        }
    }

    @Test
    public void testSendMessage() throws InterruptedException {
        String message = "Hello Kafka!";
        producer.sendMessage("test-topic", message);

        String received = consumer.getRecords().poll(10, TimeUnit.SECONDS);
        assertThat(received).isEqualTo(message);
    }

    @Component
    static class TestConsumer {
        private final BlockingQueue<String> records = new LinkedBlockingQueue<>();

        @KafkaListener(topics = "test-topic", groupId = "test-group")
        public void receive(ConsumerRecord<String, String> record) {
            records.add(record.value());
        }

        public BlockingQueue<String> getRecords() {
            return records;
        }
    }
}
