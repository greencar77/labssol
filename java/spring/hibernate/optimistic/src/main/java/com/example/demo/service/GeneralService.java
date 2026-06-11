package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeneralService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public GeneralService(CustomerRepository c, OrderRepository o) {
        this.customerRepository = c;
        this.orderRepository = o;
    }

    @Transactional
    public VersionedCustomer getCustomer(Long id) {
        return customerRepository.find(id);
    }

    @Transactional
    public List<Order> getOrdersByCustomer(Long customerId) {
        VersionedCustomer customer = customerRepository.find(customerId);
        return customer.getOrders();
    }

    @Transactional
    public void updateCustomerAndOrder(Long customerId, Long orderId, String email, Double amount) {
        VersionedCustomer c = customerRepository.find(customerId);
        Order o = orderRepository.find(orderId);
        c.setEmail(email);
        o.setAmount(amount);
        customerRepository.save(c);
        orderRepository.save(o);
    }

    @Transactional
    public VersionedCustomer createCustomerAndOrder(
            String customerName,
            String customerEmail,
            String productName,
            Double amount) {

        VersionedCustomer customer = new VersionedCustomer();
        customer.setName(customerName);
        customer.setEmail(customerEmail);
        customerRepository.create(customer);

        Order order = new Order();
        order.setProductName(productName);
        order.setAmount(amount);
        order.setCustomer(customer);
        orderRepository.create(order);

        return customer;
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}