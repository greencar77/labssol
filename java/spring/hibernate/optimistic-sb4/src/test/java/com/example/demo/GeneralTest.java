package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.DynamicCustomer;
import com.example.demo.entity.VersionedCustomer;
import com.example.demo.support.TransactionalRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GeneralTest {
    @Autowired
    private TransactionalRunner txRunner;

    @Test
    public void testTheSameAttributeNotVersioned() { //QYWE
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            Customer e1 = em1.find(Customer.class, id);
            e1.setName("FirstName");

            txRunner.doInTransaction(em2 -> {
                Customer e2 = em2.find(Customer.class, id);
                e2.setName("SecondName");
            }); //commit2
        }); //commit1

        txRunner.doInTransaction(em1 -> {
            Customer e1 = em1.find(Customer.class, id);
            //the last commiter have won
            assertEquals("FirstName", e1.getName());
        });
    }

    @Test
    public void testTheSameAttributeVersioned() { //QREZ
        long id = 100;
        Throwable exception = catchThrowable(() -> {
            txRunner.doInTransaction(em1 -> {
                VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
                assertEquals(1, e1.getVersion());
                e1.setName("FirstName");

                txRunner.doInTransaction(em2 -> {
                    VersionedCustomer e2 = em2.find(VersionedCustomer.class, id);
                    assertEquals(1, e1.getVersion());
                    e2.setName("SecondName");
                }); //commit2
            }); //commit1
        });

        assertNotNull(exception);
        assertEquals(ObjectOptimisticLockingFailureException.class, exception.getClass());
    }

    @Test
    public void testDifferentAttributesNotVersioned() { //QHX6
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            Customer e1 = em1.find(Customer.class, id);
            e1.setName("FirstName");

            txRunner.doInTransaction(em2 -> {
                Customer e2 = em2.find(Customer.class, id);
                e2.setEmail("NEW@email");
            }); //commit2
        }); //commit1

        txRunner.doInTransaction(em1 -> {
            Customer e1 = em1.find(Customer.class, id);
            //the last commiter have won
            assertEquals("FirstName", e1.getName());
            assertEquals("bob@x.com", e1.getEmail()); //remains intact
        });
    }

    @Test
    public void testDifferentAttributesDynamic() { //QFR2
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            DynamicCustomer e1 = em1.find(DynamicCustomer.class, id);
            e1.setName("FirstName");

            txRunner.doInTransaction(em2 -> {
                DynamicCustomer e2 = em2.find(DynamicCustomer.class, id);
                e2.setEmail("NEW@email");
            }); //commit2
        }); //commit1

        txRunner.doInTransaction(em1 -> {
            DynamicCustomer e1 = em1.find(DynamicCustomer.class, id);
            assertEquals("FirstName", e1.getName()); //a value from first updater
            assertEquals("NEW@email", e1.getEmail()); //a value from second updater
        });
    }
}
