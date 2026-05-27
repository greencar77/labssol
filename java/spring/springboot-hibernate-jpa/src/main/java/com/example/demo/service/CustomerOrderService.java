package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerOrderService(CustomerRepository c, OrderRepository o) {
        this.customerRepository = c;
        this.orderRepository = o;
    }

    public List<Order> getOrdersByCustomer(Long id) {
        return orderRepository.findByCustomerId(id);
    }

    @Transactional
    public void updateCustomerAndOrder(Long customerId, Long orderId, String email, Double amount) {
        Customer c = customerRepository.findById(customerId).orElseThrow();
        Order o = orderRepository.findById(orderId).orElseThrow();
        c.setEmail(email);
        o.setAmount(amount);
        customerRepository.save(c);
        orderRepository.save(o);
    }

    @Transactional
    public Customer createCustomerAndOrder(
            String customerName,
            String customerEmail,
            String productName,
            Double amount) {

        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setEmail(customerEmail);

        customer = customerRepository.save(customer);

        Order order = new Order();
        order.setProductName(productName);
        order.setAmount(amount);
        order.setCustomer(customer);

        orderRepository.save(order);

        return customer;
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}