package com.bilin.rabbitmq.spring;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="mQProducerImpl")
public class MQProducerImpl implements MQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

	@Override
	public void sendDataToQueue(Object object) {
		 System.out.println("=========发送消息开始=============消息：" + object.toString());
         amqpTemplate.convertAndSend(object);
	}
    
    
    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            System.out.println("=========发送消息开始=============消息：" + object.toString());
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
