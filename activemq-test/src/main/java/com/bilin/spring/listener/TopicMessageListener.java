package com.bilin.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMessageListener implements MessageListener{
	
	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("QueueMessageListener监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
