package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.business.domain.Message;
import com.example.business.service.MessageService;

//TODO 演習4 不足しているアノテーションを記述しなさい
public class MessageServiceTest {
	@Autowired
	MessageService messageService;

	@Test
	public void testFindOne() {
		Message message = messageService.findOne();
		//TODO 演習4 不足している処理を記述しなさい
	}
}