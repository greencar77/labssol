http://localhost:8080/h2-console


jdbc:h2:mem:testdb

in h2 console
http://localhost:8080/api/create

{
  "customerName": "John Smith",
  "customerEmail": "john@example.com",
  "productName": "Laptop",
  "amount": 999.99
}

DELETE http://localhost:8080/api/orders/1