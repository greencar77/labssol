package com.example.demo.repository;

import com.example.demo.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer find(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public Customer save(Customer customer) {
        return entityManager.merge(customer);
    }
}