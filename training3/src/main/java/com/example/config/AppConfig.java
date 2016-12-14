package com.example.config;

import org.springframework.context.annotation.Bean;

import com.example.business.repository.MessageRepository;
import com.example.infrastructure.MessageRepositoryImpl;

// TODO 演習3 アノテーションを記述しなさい
public class AppConfig {
	@Bean
	public MessageRepository messageRepository(){
		return new MessageRepositoryImpl();
	}
}
