# Kafka Demo Application Instructions

This project demonstrates a simple Spring Boot application with a Kafka producer and consumer.

## Prerequisites

- Java 17 or higher
- Docker and Docker Compose (See [Docker Installation Guide](DOCKER_INSTALL.md))
- Maven (optional, if you want to build from source)

## Step 1: Start Kafka

The project includes a `docker-compose.yml` file to start a local Kafka broker and Zookeeper instance.

Run the following command in the project root:

```bash
docker-compose up -d
```

## Step 2: Build and Run the Application

### Using Maven

If you have Maven installed, you can run the application directly:

```bash
mvn spring-boot:run
```

### Using an IDE

Open the project in your favorite IDE (IntelliJ IDEA, Eclipse, VS Code) and run the `KafkaDemoApplication` class.

## Step 3: Verify the Output

Once the application is running, you will see logs in the console.

- **Producer:** Every 5 seconds, the `KafkaProducerService` generates a message and sends it to the `demo-topic`.
- **Consumer:** The `KafkaConsumerService` listens to the `demo-topic` and logs every message it receives.

Example output:
```text
Producing message: Message generated at 1718458112345 with UUID: ...
Consumed message: Message generated at 1718458112345 with UUID: ...
```

## Stopping the environment

To stop the Kafka and Zookeeper containers:

```bash
docker-compose down
```

## Troubleshooting

### Connection Errors (localhost:9092)

If you see an error like `Connection to node -1 (localhost/127.0.0.1:9092) could not be established`, it means the application cannot find the Kafka broker.

**Important Note for "Per-user" Installations:**
If you installed Docker Desktop using the "Per-user" mode, ensure that:
1.  **Docker Desktop is running:** Look for the Docker whale icon in your system tray.
2.  **Containers are started:** Even with a per-user installation, you must explicitly run `docker-compose up -d` in the project root to start Kafka.

1.  **Check if containers are running:**
    ```bash
    docker ps
    ```
    You should see both `zookeeper` and `kafka` containers in the list.

2.  **Restart the containers:**
    Sometimes the broker starts before Zookeeper is ready. Try restarting:
    ```bash
    docker-compose restart kafka
    ```
    Or recreate them:
    ```bash
    docker-compose down
    docker-compose up -d
    ```

3.  **Check container logs:**
    If the containers are running but you still can't connect, check the Kafka logs:
    ```bash
    docker-compose logs kafka
    ```

4.  **Wait for startup:**
    Kafka can take a few seconds to fully initialize and become available on port 9092. Wait about 10-15 seconds after `docker-compose up -d` before starting the Spring Boot application.
