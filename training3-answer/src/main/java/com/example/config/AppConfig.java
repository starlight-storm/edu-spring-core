package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.business.repository.MessageRepository;
import com.example.business.service.MessageService;
import com.example.business.service.MessageServiceImpl;
import com.example.infrastructure.MessageRepositoryImpl;

@Configuration
@ComponentScan("com.example")
public class AppConfig {
	@Bean
	public MessageRepository messageRepository(){
		return new MessageRepositoryImpl();
	}

	@Bean
	public MessageService messageService(){
		return new MessageServiceImpl(messageRepository());
	}
}
