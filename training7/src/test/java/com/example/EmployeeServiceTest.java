package com.example;

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

	// TODO 演習7 不足しているアノテーションを記述しなさい
	public void testCreate() {
		// テスト対象メソッドの実行
		Employee emp = new Employee();
		emp.setName("大下");
		emp.setMail("oosita@sample.jp");
		employeeService.create(emp);
	}

	// TODO 演習7 EmployeeServiceのfindById()のテストを記述しなさい
}