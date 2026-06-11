package com.example.demo.repository;

import com.example.demo.entity.Order;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Order find(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    public void create(Order order) {
        entityManager.persist(order);
    }

    @Transactional
    public Order save(Order order) {
        return entityManager.merge(order);
    }

    @Transactional
    public void deleteById(Long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        entityManager.remove(order);
    }
}