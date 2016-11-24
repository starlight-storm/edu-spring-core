package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.business.domain.Message;
import com.example.business.service.MessageService;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	private void run() {
		MessageService messageService = (MessageService) createApplicationContext().getBean("messageService");
		Message msg = messageService.findOne();
		System.out.println("Greeting Massage: " + msg.getValue());
	}

	private ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/com/example/config/applicationContext.xml");
	}
}