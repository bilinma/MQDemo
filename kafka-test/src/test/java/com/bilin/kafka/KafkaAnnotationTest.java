package com.bilin.kafka;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ucloudlink.kafka.common.DateUtil;
import com.ucloudlink.kafka.spring.annotation.KafkaProducer;
import com.ucloudlink.kafka.spring.annotation.SpringConfig;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})
public class KafkaAnnotationTest {
	
	@Resource
	private KafkaProducer kafkaProducer;
	@Test
	public void testProducer() throws InterruptedException {
		String dateStr = DateUtil.getDateString();
		
		kafkaProducer.sendMessage("spring-topic", dateStr+":maxiaobin");
		Thread.sleep(5000);
	}


}
