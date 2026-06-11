package com.example.demo.repository;

import com.example.demo.entity.VersionedCustomer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public VersionedCustomer find(Long id) {
        return entityManager.find(VersionedCustomer.class, id);
    }

    @Transactional
    public void create(VersionedCustomer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public VersionedCustomer save(VersionedCustomer customer) {
        return entityManager.merge(customer);
    }
}