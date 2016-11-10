package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

public class MessageServiceImpl implements MessageService {
	private MessageRepository messageRepository;

// 演習1 TODO：不足しているメソッドを追加してください。

	public Message findOne() {
		return messageRepository.findOne();
	}
}