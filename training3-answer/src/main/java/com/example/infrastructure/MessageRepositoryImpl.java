package com.example.infrastructure;

import org.springframework.stereotype.Repository;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
	public Message findOne() {
		return new Message("Hello DI Annotation!");
	}
}
