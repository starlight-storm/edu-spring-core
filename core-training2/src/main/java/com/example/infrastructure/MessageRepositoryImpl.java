package com.example.infrastructure;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

//TODO 演習2 不足しているアノテーションを記述しなさい
public class MessageRepositoryImpl implements MessageRepository {
	public Message findOne() {
		return new Message("Hello DI Annotation!");
	}
}
