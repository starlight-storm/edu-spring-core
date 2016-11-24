package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

public class MessageServiceImpl implements MessageService {

	MessageRepository messageRepository;

	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Message findOne() {
		return messageRepository.findOne();
	}
}