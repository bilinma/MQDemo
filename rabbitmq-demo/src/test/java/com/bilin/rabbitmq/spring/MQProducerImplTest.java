package com.bilin.rabbitmq.spring;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class MQProducerImplTest {

	@Autowired
	private MQProducer mQProducer;

	@Test
	public void testSendDataToQueue() {
		Map<String, Object> msg = new HashMap<>();
		msg.put("data", "hello,spring.direct.test1");
		mQProducer.sendDataToQueue(msg);
		
		Map<String, Object> msg2 = new HashMap<>();
		msg2.put("data", "hello,spring.direct.test2");
		mQProducer.sendDataToQueue("spring.direct.test2",msg2);
	}

}
