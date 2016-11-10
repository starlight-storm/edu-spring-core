package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

//演習2 TODO 不足しているアノテーションを記述しなさい
public class MessageServiceImpl implements MessageService {
	//演習2 TODO 不足しているアノテーションを記述しなさい
	MessageRepository messageRepository;

	public Message findOne() {
		return messageRepository.findOne();
	}
}