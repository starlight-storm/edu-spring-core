package com.example.customer.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/example/customer/config/applicationContext.xml")
@ActiveProfiles({ "product", "test" })
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
	DbUnitTestExecutionListener.class})
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	// TODO 演習7 不足しているアノテーションを記述しなさい
	
	// TODO 演習7 不足しているアノテーションを記述しなさい
	public void testUpdate() {
		Customer customer = customerService.findById(0);
		customer.setName("花子");
		customerService.update(customer);
	}
}