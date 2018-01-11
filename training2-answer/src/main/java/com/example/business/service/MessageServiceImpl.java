package com.example.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	public Message findOne() {
		return messageRepository.findOne();
	}
}