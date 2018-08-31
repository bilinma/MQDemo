package com.bilin.rabbitmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bilin.rabbitmq.spring.MQProducer;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
        MQProducer mqProducer=(MQProducer) applicationContext.getBean("mQProducerImpl");
        for(int i=0;i<10;i++){
        	/*mqProducer.sendDataToQueue("Hello World spring.direct.test1");
        	mqProducer.sendDataToQueue("spring.direct.test2","Hello World spring.direct.test2");*/
        	
        	/*mqProducer.sendDataToQueue("Hello World spring.fanout.test1:"+i);
        	mqProducer.sendDataToQueue("spring.fanout.test2","Hello World spring.fanout.test2:"+i);*/
        	
        	mqProducer.sendDataToQueue("Hello World spring.topic.test1:"+i);
        	mqProducer.sendDataToQueue("spring.topic.test2.pattern","Hello World spring.topic.test2:"+i);
        	
        	Thread.sleep(1000);
        }
    }
	
}
