QSNB
In Kafka, if multiple consumers belong to the **same consumer group**, they share the workload. This means that a single message will be delivered to only one of the consumers in that group (load balancing).

Currently, both `KafkaConsumerService` and `SecondConsumerService` have `groupId = "demo-group"`. To allow both services to consume the same message, you need to assign them to **different consumer groups**.

### Why they are not receiving the same message now
In your current code:
- `KafkaConsumerService` uses `groupId = "demo-group"`.
- `SecondConsumerService` uses `groupId = "demo-group"`.

Because they share the same group ID, Kafka treats them as a single logical consumer, distributing the partitions of the topic among them.

### Solution: Use different Consumer Groups
Change the `groupId` in one of the services so that each service belongs to its own unique group.

#### 1. Update `KafkaConsumerService.java`
Keep its group as is:
```java
@KafkaListener(topics = "demo-topic", groupId = "group-1")
public void consume(String message) {
    logger.info("Consumer 1 received: {}", message);
}
```

#### 2. Update `SecondConsumerService.java`
Change its group to something different:
```java
@KafkaListener(topics = "demo-topic", groupId = "group-2")
public void consume(String message) {
    logger.info("Consumer 2 received: {}", message);
}
```

### Summary of Changes
By giving each service a unique `groupId`, Kafka will treat them as independent subscribers. Each group will maintain its own offset, and every message published to `demo-topic` will be delivered to one consumer in `group-1` AND one consumer in `group-2`. In your case, since you have one service per group, both `KafkaConsumerService` and `SecondConsumerService` will receive every message.