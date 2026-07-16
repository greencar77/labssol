package batch;
 
import com.example.demo.DemoApplication;
import com.example.demo.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class EntityManagerQueryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testJPQL() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
        query.setParameter("name", "Bob");
        
        List<Customer> customers = query.getResultList();
        
        assertFalse(customers.isEmpty(), "Customers list should not be empty");
        customers.forEach(c -> System.out.println("Customer name: " + c.getName()));
    }

    @Test
    @Rollback(false)
    public void testBatchInsert() {
        int batchSize = 10;
        for (int i = 0; i < batchSize; i++) {
            Customer customer = new Customer();
            customer.setName("Customer " + i);
            customer.setEmail("customer" + i + "@example.com");
            entityManager.persist(customer);
        }
        entityManager.flush();
        entityManager.clear();

        Long count = entityManager.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.name LIKE 'Customer %'", Long.class)
                .getSingleResult();
        assertEquals((long) batchSize, count);
    }
}
