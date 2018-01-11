package com.example.customer.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
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
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

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

	@Test
	@DatabaseSetup("customer_init_data.xml")
	public void testFindById() {
		Customer customer = customerService.findById(0);
		assertThat("太郎", equalTo(customer.getName()));
	}
	
	@Test
	@DatabaseSetup("customer_init_data.xml")
	@ExpectedDatabase("customer_after_create_data.xml")
	public void testUpdate() {
		// テスト対象メソッドの実行
		Customer customer = customerService.findById(0);
		customer.setName("花子");
		customerService.update(customer);
	}
}