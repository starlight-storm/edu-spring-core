package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.business.domain.Message;
import com.example.business.service.MessageService;

// 演習3 TODO: 不足しているアノテーションを記述しなさい
public class MessageServiceTest {
	@Autowired
	MessageService messageService;

	@Test
	public void testFindOne() {
		Message message = messageService.findOne();
		// 演習3 TODO: 不足している処理を記述しなさい
	}
}