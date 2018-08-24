package com.bilin.spring.service;

public interface AMQSenderService {
	
	public void sendQueueMessage(final String msg);
	
	public void sendTopicMessage(final String msg);
	
}
