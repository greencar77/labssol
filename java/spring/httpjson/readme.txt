mvn spring-boot:run

curl http://localhost:8080/api/message


curl -X POST http://localhost:8080/api/message \
  -H "Content-Type: application/json" \
  -d '{"text":"New value"}'