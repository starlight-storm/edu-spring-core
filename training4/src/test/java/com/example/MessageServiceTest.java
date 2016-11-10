package com.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.business.domain.Message;
import com.example.business.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "./config/applicationContext.xml" })
public class MessageServiceTest {
	@Autowired
	MessageService messageService;

	@Test
	public void testFindOne() {
		Message message = messageService.findOne();
		Message testMessage = new Message("Hello DI Annotation!");
		assertThat(testMessage, equalTo(message));
	}
}