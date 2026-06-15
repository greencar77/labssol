### Kafka UI for Monitoring
Yes, it is definitely possible to see messages, consumer groups, and topic statistics using a Kafka UI. Since you are already using Docker Compose, the easiest way to achieve this is by adding a UI service to your `docker-compose.yml` file.

One of the most popular and easy-to-use options is **UI for Apache Kafka** (by Provectus).

#### 1. Update `docker-compose.yml`
You can add the following service to your `docker-compose.yml`:

```yaml
  kafka-ui:
    image: provectuslabs/kafka-ui:latest
    ports:
      - "8080:8080"
    depends_on:
      - kafka
    environment:
      KAFKA_CLUSTERS_0_NAME: local
      KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: kafka:29092
      KAFKA_CLUSTERS_0_ZOOKEEPER: zookeeper:2181
```

#### 2. How to use it
1.  **Start the services**: Run `docker-compose up -d`.
2.  **Access the UI**: Open your browser and go to `http://localhost:8080`.
3.  **What you can see**:
    *   **Topics**: See all topics (like `demo-topic`), the number of partitions, and the total message count.
    *   **Messages**: Click on a topic to "Live Tail" or browse through the messages that have been sent.
    *   **Consumer Groups**: See all active consumer groups (like `demo-group` and `demo-group2`), their current offsets, and "Lag" (how many messages are waiting to be processed).
    *   **Brokers**: Monitor the status of your Kafka broker.

#### 3. Other Popular Alternatives
If you want to explore other options, here are two very common ones:
*   **AKHQ**: A powerful, feature-rich UI for managing Kafka clusters.
*   **Conduktor**: A desktop-based application (GUI) that provides a very professional and deep interface for Kafka management.

### Summary
By adding a UI, you don't have to rely on console logs to verify if messages are arriving or if your consumers are working. You can see the real-time flow of data and manage your consumer groups visually.