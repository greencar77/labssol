package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public GeneralService(CustomerRepository c, OrderRepository o) {
        this.customerRepository = c;
        this.orderRepository = o;
    }

    @Transactional //Q7R4
    public Customer getCustomer(Long id) {
        return customerRepository.find(id);
    }

    @Transactional
    public List<Order> getOrdersByCustomer(Long customerId) {
        Customer customer = customerRepository.find(customerId);
        return customer.getOrders();
    }

    @Transactional //QFLR
    public void updateCustomerAndOrder(Long customerId, Long orderId, String email, Double amount) {
        Customer c = customerRepository.find(customerId);
        Order o = orderRepository.find(orderId);
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