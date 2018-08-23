package com.bilin.activemq.queue.consumer;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.bilin.activemq.common.ActiveMQUtil;

public class Comsumer {

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();
    AtomicInteger count = new AtomicInteger();

    public void getMessage(String disname){
        try {
        	Session session = ActiveMQUtil.getSession(false,Session.AUTO_ACKNOWLEDGE);
        	
            Queue queue = session.createQueue(disname);
            MessageConsumer consumer = null;

            if(threadLocal.get()!=null){
                consumer = threadLocal.get();
            }else{
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            
            while(true){
                Thread.sleep(1000);
                TextMessage msg = (TextMessage) consumer.receive();
                if(msg!=null) {
                    msg.acknowledge();
                    System.out.println(Thread.currentThread().getName()+": Consumer:我是消费者，我正在消费Msg"+msg.getText()+"--->"+count.getAndIncrement());
                }else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
