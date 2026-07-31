package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.service.GeneralService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GeneralTest {

    @Autowired
    private GeneralService generalService;

    @Test
    public void testReadAndWrite() {
        Customer customer;
//        customer = generalService.getCustomer(100L);
//        assertEquals("Bob", customer.getName());
        generalService.readAndWrite();
        customer = generalService.getCustomer(100L);
        assertEquals("Updated Name", customer.getName());
    }

    //QF7I
    @Test
    public void testReadAndWriteReadOnly() {
        Customer customer;
        generalService.readAndWriteReadOnly();
        customer = generalService.getCustomer(100L);
        assertEquals("Bob", customer.getName()); //the value hasn't changed due to readOnly
    }
}
