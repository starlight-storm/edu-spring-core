package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.business.domain.Message;
import com.example.business.service.MessageService;
import com.example.config.AppConfig;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	private void run() {
		MessageService messageService = (MessageService) createApplicationContext().getBean(MessageService.class);
		Message msg = messageService.findOne();
		System.out.println("Greeting Massage: " + msg.getValue());
	}

	private AnnotationConfigApplicationContext createApplicationContext() {
		return new AnnotationConfigApplicationContext(AppConfig.class);
	}
}