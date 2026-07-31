package com.example.demo.controller;

import com.example.demo.dto.CreateOrderRequest;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.service.GeneralService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {
    private final GeneralService service;

    public GeneralController(GeneralService service) {
        this.service = service;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Customer result = service.getCustomer(id);
        return result;
    }

    @GetMapping("/customers/{id}/orders")
    public List<Order> getOrders(@PathVariable Long id) {
        return service.getOrdersByCustomer(id);
    }

    @PutMapping("/update")
    public String update(@RequestParam Long customerId, @RequestParam Long orderId, @RequestParam String email, @RequestParam Double amount) {
        service.updateCustomerAndOrder(customerId, orderId, email, amount);
        return "Updated successfully";
    }

    @PostMapping("/create")
    public String create(@RequestBody CreateOrderRequest request) {
        service.createCustomerAndOrder(
                request.getCustomerName(),
                request.getCustomerEmail(),
                request.getProductName(),
                request.getAmount());
        return "Customer and order created";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return "Order deleted";
    }
}