package com.example;

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

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/example/config/applicationContext.xml")
@ActiveProfiles({ "product", "test" })
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
	DbUnitTestExecutionListener.class})
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;

	@Test
	@DatabaseSetup("employee_init_data.xml")
	@ExpectedDatabase("employee_after_create_data.xml")
	public void testCreate() {
		// テスト対象メソッドの実行
		Employee emp = new Employee();
		emp.setName("大下");
		emp.setMail("oosita@sample.jp");
		employeeService.create(emp);
	}

	@Test
	@DatabaseSetup("employee_init_data.xml")
	public void testFindById() {
		Employee emp = employeeService.findById(0);
		assertThat("伊藤", equalTo(emp.getName()));
	}
}