package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.service.GeneralService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MainTest {
	@Autowired
	private GeneralService generalService;

	@Test
	@Transactional
	public void testFind() {
		//try different FetchType in Customer
		Customer customer = generalService.getCustomer(100L);
        System.out.println(customer);
        System.out.println(customer.getOrders().size());
	}
}
