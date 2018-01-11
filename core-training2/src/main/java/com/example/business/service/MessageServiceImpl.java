package com.example.business.service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

//TODO 演習2 不足しているアノテーションを記述しなさい
public class MessageServiceImpl implements MessageService {
	//TODO 演習2 不足しているアノテーションを記述しなさい
	private MessageRepository messageRepository;

	public Message findOne() {
		return messageRepository.findOne();
	}
}