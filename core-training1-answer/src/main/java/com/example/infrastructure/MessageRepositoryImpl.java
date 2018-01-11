package com.example.infrastructure;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

public class MessageRepositoryImpl implements MessageRepository {

	public Message findOne() {
		return new Message("Hello DI!");
	}
}
