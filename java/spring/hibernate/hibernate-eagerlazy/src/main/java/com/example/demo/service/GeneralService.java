package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Service
public class GeneralService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private org.springframework.core.env.Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public GeneralService(CustomerRepository c, OrderRepository o) {
        this.customerRepository = c;
        this.orderRepository = o;
    }

    @Transactional
    public Customer getCustomer(Long id) {
        return customerRepository.find(id);
    }

    @Transactional
    public List<Order> getOrdersByCustomer(Long customerId) {
        Customer customer = customerRepository.find(customerId);
        return customer.getOrders();
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}