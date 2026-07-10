package com.example.sakila;

import com.example.sakila.entity.Actor;
import com.example.sakila.entity.Film;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(HibernateConfig.class)
@Transactional
public class SessionFactoryQueryTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testHQL() {
        System.out.println("--- Testing HQL (Hibernate Query Language) ---");
        Session session = sessionFactory.getCurrentSession();
        
        // HQL uses entity names instead of table names
        Query<Actor> query = session.createQuery("from Actor where firstName = :name", Actor.class);
        query.setParameter("name", "PENELOPE");
        
        List<Actor> actors = query.getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }

    @Test
    public void testJPQL() {
        System.out.println("--- Testing JPQL (Java Persistence Query Language) ---");
        Session session = sessionFactory.getCurrentSession();
        
        // JPQL is very similar to HQL, standard JPA
        List<Film> films = session.createQuery("SELECT f FROM Film f WHERE f.rentalRate > 4.0", Film.class)
                .setMaxResults(5)
                .getResultList();
        
        assertFalse(films.isEmpty());
        films.forEach(System.out::println);
    }

    @Test
    public void testCriteriaAPI() {
        System.out.println("--- Testing Criteria API ---");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        
        CriteriaQuery<Actor> cr = cb.createQuery(Actor.class);
        Root<Actor> root = cr.from(Actor.class);
        cr.select(root).where(cb.like(root.get("lastName"), "GU%"));
        
        Query<Actor> query = session.createQuery(cr);
        List<Actor> actors = query.getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }

    @Test
    public void testNativeSQL() {
        System.out.println("--- Testing Native SQL ---");
        Session session = sessionFactory.getCurrentSession();
        
        // Native SQL uses actual table names
        List<Object[]> results = session.createNativeQuery("SELECT actor_id, first_name, last_name FROM actor LIMIT 5", Object[].class)
                .getResultList();
        
        assertFalse(results.isEmpty());
        for (Object[] row : results) {
            System.out.println("ID: " + row[0] + ", Name: " + row[1] + " " + row[2]);
        }
    }

    @Test
    public void testNamedQuery() {
        System.out.println("--- Testing Named Query ---");
        Session session = sessionFactory.getCurrentSession();
        
        List<Actor> actors = session.createNamedQuery("Actor.findByName", Actor.class)
                .setParameter("firstName", "NICK")
                .getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }
}
