package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

//TODO 演習3 アノテーションがないことを確認
public class MessageServiceImpl implements MessageService {

	// TODO 演習3 アノテーションがないことを確認
	MessageRepository messageRepository;

	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Message findOne() {
		return messageRepository.findOne();
	}
}