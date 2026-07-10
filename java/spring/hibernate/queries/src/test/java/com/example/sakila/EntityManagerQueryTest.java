package com.example.sakila;

import com.example.sakila.entity.Actor;
import com.example.sakila.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringJUnitConfig(HibernateConfig.class)
@Transactional
public class EntityManagerQueryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testJPQL() {
        System.out.println("--- EntityManager: Testing JPQL (Java Persistence Query Language) ---");
        
        // JPQL is the standard JPA query language
        TypedQuery<Actor> query = entityManager.createQuery("SELECT a FROM Actor a WHERE a.firstName = :name", Actor.class);
        query.setParameter("name", "PENELOPE");
        
        List<Actor> actors = query.getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }

    @Test
    public void testCriteriaAPI() {
        System.out.println("--- EntityManager: Testing JPA Criteria API ---");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Actor> cr = cb.createQuery(Actor.class);
        Root<Actor> root = cr.from(Actor.class);
        cr.select(root).where(cb.like(root.get("lastName"), "GU%"));
        
        TypedQuery<Actor> query = entityManager.createQuery(cr);
        List<Actor> actors = query.getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }

    @Test
    public void testNativeSQL() {
        System.out.println("--- EntityManager: Testing Native SQL ---");
        
        // Native SQL using EntityManager
        List<Object[]> results = entityManager.createNativeQuery("SELECT actor_id, first_name, last_name FROM actor LIMIT 5")
                .getResultList();
        
        assertFalse(results.isEmpty());
        for (Object[] row : results) {
            System.out.println("ID: " + row[0] + ", Name: " + row[1] + " " + row[2]);
        }
    }

    @Test
    public void testNamedQuery() {
        System.out.println("--- EntityManager: Testing Named Query ---");
        
        List<Actor> actors = entityManager.createNamedQuery("Actor.findByName", Actor.class)
                .setParameter("firstName", "NICK")
                .getResultList();
        
        assertFalse(actors.isEmpty());
        actors.forEach(System.out::println);
    }

    @Test
    public void testStoredProcedure() {
        System.out.println("--- EntityManager: Testing Stored Procedure (Example) ---");
        // Sakila has some stored procedures, but calling them often requires specific setup.
        // This is just to demonstrate the EntityManager capability.
        // For example: entityManager.createStoredProcedureQuery("some_proc_name")
        System.out.println("EntityManager supports stored procedures via createStoredProcedureQuery()");
    }

    @Test
    public void testJoinCityCountry() {
        System.out.println("--- EntityManager: Testing Join (City and Country) ---");

        // Demonstration of a query joining two tables (City and Country)
        // Returning city list ordered by country name and then city name
        TypedQuery<City> query = entityManager.createQuery(
                "SELECT c FROM City c JOIN FETCH c.country co ORDER BY co.country ASC, c.city ASC", City.class);
        query.setMaxResults(10);

        List<City> cities = query.getResultList();

        assertFalse(cities.isEmpty());
        for (City city : cities) {
            System.out.println("City: " + city.getCity() + ", Country: " + city.getCountry().getCountry());
        }
    }
}
