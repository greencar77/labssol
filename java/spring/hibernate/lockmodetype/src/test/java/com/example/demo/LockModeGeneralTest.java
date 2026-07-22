package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.VersionedCustomer;
import com.example.demo.support.TransactionalRunner;
import jakarta.persistence.LockModeType;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LockModeGeneralTest {

    @Autowired
    private TransactionalRunner txRunner;

    @Test
    public void testNoOtherModifierLockModeNoVersion() { //QC5A
        long id = 100;
        HibernateException result = assertThrows(HibernateException.class, () -> {
            txRunner.doInTransaction(em1 -> {
                em1.find(Customer.class, id, LockModeType.OPTIMISTIC);
            });
        });

        assertEquals("Entity 'com.example.demo.entity.Customer' has no version and may not be locked at level OPTIMISTIC", result.getMessage());
    }

    @Test
    public void testOptimisticLockModeVersionAndChanges() {
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id, LockModeType.OPTIMISTIC);
            e1.setName("FirstName");
            assertEquals(1, e1.getVersion());
        });

        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
            assertEquals("FirstName", e1.getName());
            assertEquals(2, e1.getVersion());
        });
    }

    @Test
    public void testOptimisticLockModeVersionAndNoChanges() {
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id, LockModeType.OPTIMISTIC);
            //no changes
            assertEquals(1, e1.getVersion());
        });

        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
            assertEquals("Bob", e1.getName());
            assertEquals(1, e1.getVersion(), "No changes in version expected since object wasn't altered");
        });
    }

    @Test
    public void testOptimisticForceIncrementLockModeVersionChanges() {
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            //no changes
            assertEquals(1, e1.getVersion());
        });

        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
            assertEquals("Bob", e1.getName());
            assertEquals(2, e1.getVersion(), "Version increment expected although object wasn't altered");
        });
    }

    @Test
    public void testNONE() {
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id, LockModeType.NONE);
            //no changes
            assertEquals(1, e1.getVersion());
        });

        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
            assertEquals("Bob", e1.getName());
            assertEquals(1, e1.getVersion());
        });
    }

    @Test
    public void testNONE2AndChanges() {
        long id = 100;
        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id, LockModeType.NONE);
            e1.setName("NewFirstName");
            assertEquals(1, e1.getVersion());
        });

        txRunner.doInTransaction(em1 -> {
            VersionedCustomer e1 = em1.find(VersionedCustomer.class, id);
            assertEquals("NewFirstName", e1.getName());
            assertEquals(2, e1.getVersion());
        });
    }
}
