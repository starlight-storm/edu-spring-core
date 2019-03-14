package com.example.infrastructure;

import com.example.business.domain.Message;
import com.example.business.repository.MessageRepository;

//TODO 演習3 アノテーションがないことを確認
public class MessageRepositoryImpl implements MessageRepository {
	public Message findOne() {
		return new Message("Hello DI JavaConfig!");
	}
}
