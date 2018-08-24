package com.bilin.activemq;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bilin.spring.service.AMQSenderService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class AMQSenderServiceImplTest {

	@Resource
	private AMQSenderService amqSenderService;
	
	@Test
	public void testSendQueueMessage() throws InterruptedException {
		for(int i=1;i<100;i++){
			amqSenderService.sendQueueMessage(String.valueOf(i));
		}
	}

	@Test
	public void testSendTopicMessage() {
		for(int i=1;i<100;i++){
			amqSenderService.sendTopicMessage(String.valueOf(i));
		}
	}

}
