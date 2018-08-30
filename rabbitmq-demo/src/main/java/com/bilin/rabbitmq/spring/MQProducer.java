package com.bilin.rabbitmq.spring;

public interface MQProducer {
	
	public void sendDataToQueue(Object object);
	
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
}