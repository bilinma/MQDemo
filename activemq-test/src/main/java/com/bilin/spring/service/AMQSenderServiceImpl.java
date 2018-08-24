package com.bilin.spring.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class AMQSenderServiceImpl implements AMQSenderService{

    private static final Logger logger = LoggerFactory.getLogger(AMQSenderServiceImpl.class);

    @Resource
    private JmsTemplate jmsTemplate;

    //目的地队列的明证，我们要向这个队列发送消息
    @Resource
    private Destination destinationQueue;
    
    @Resource
    private Destination destinationTopic;

    //向特定的队列发送消息
    @Override
    public void sendQueueMessage(final String msg) {
        try {
            logger.info("将要向队列{}发送的消息msg:{}", destinationQueue, msg);
            jmsTemplate.send(destinationQueue, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });

        } catch (Exception ex) {
            logger.error("向队列{}发送消息失败，消息为：{}", destinationQueue, msg);
        }
    }
    
    
    //向特定的队列发送消息
    @Override
    public void sendTopicMessage(final String msg) {
        try {
            logger.info("将要向主题{}发送的消息msg:{}", destinationTopic, msg);
            jmsTemplate.send(destinationTopic, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });
        } catch (Exception ex) {
            logger.error("向主题{}发送消息失败，消息为：{}", destinationTopic, msg);
        }
    }
	
}
