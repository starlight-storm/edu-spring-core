package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

public class MessageServiceImpl implements MessageService {
	private MessageRepository messageRepository;

//TODO 演習1 不足しているメソッドを追加してください。

	public Message findOne() {
		return messageRepository.findOne();
	}
}