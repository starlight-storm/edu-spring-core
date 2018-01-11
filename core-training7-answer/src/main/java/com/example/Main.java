package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		CustomerService customerService = (CustomerService) createApplicationContext().getBean("customerService");
		System.out.println("---findAll");
		findAll(customerService);
		System.out.println("---findById");
		findById(customerService, 1); // IDを固定していますが、0に書き換えても動作可能
		System.out.println("---update");
		update(customerService, 1); // IDを固定していますが、0に書き換えても動作可能
		System.out.println("---findAll 2");
		findAll(customerService);
	}

	private void findAll(CustomerService customerService) {
		List<Customer> customerList = customerService.findAll();
		for (Customer customer : customerList) {
			System.out.println("顧客: " + customer);
		}
	}

	private void findById(CustomerService customerService, int id) {
		System.out.println("顧客: " + customerService.findById(id));
	}

	private void update(CustomerService customerService, int id) {
		Customer customer = customerService.findById(id);
		customer.setName("佐藤");
		customerService.update(customer);
		System.out.println("更新後顧客: " + customerService.findById(id));
	}
	
	private ApplicationContext createApplicationContext() {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("product", "test");
		context.load("/com/example/customer/config/applicationContext.xml");
		context.refresh();  
		return context;
	}
}