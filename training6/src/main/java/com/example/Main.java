package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	// TODO 演習6 最初にfindAll()を作成する。
	// findAll()がうまく動作をしたところで、findById()部分のコメントを外して作成。
	// findById()がうまく動作をしたところで…という風に順番にメソッドを作成する。
	private void run() {
		EmployeeService employeeService = (EmployeeService) createApplicationContext().getBean("employeeService");
		System.out.println("---findAll");
		findAll(employeeService);
//		System.out.println("---findById");
//		findById(employeeService, 1); // IDを固定していますが、0に書き換えても動作可能
//		System.out.println("---create");
//		create(employeeService);
//		System.out.println("---findAll 2");
//		findAll(employeeService);
	}

	private void findAll(EmployeeService employeeService) {
		List<Employee> empList = employeeService.findAll();
		for (Employee emp : empList) {
			System.out.println("社員: " + emp);
		}
	}

	private void findById(EmployeeService employeeService, int id) {
		System.out.println("社員: " + employeeService.findById(id));
	}

	private void create(EmployeeService employeeService) {
		Employee emp = new Employee();
		emp.setName("佐藤");
		emp.setMail("saito@sample.jp");
		int cnt = employeeService.create(emp);
		System.out.println("登録: " + cnt + "件");
	}
	
	private ApplicationContext createApplicationContext() {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("product", "test");
		context.load("/com/example/config/applicationContext.xml");
		context.refresh();  
		return context;
	}
}