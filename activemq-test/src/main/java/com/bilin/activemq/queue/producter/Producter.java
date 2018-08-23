package com.bilin.activemq.queue.producter;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.bilin.activemq.common.ActiveMQUtil;

public class Producter {

    AtomicInteger count = new AtomicInteger(0);
    
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();


    public void sendMessage(String disname){
        try {
        	Session session = ActiveMQUtil.getSession(true,Session.SESSION_TRANSACTED);
            //创建一个消息队列
            Queue queue = session.createQueue(disname);
            //消息生产者
            MessageProducer messageProducer = null;
            if(threadLocal.get()!=null){
                messageProducer = threadLocal.get();
            }else{
                messageProducer = session.createProducer(queue);
                threadLocal.set(messageProducer);
            }
           while(true){
                Thread.sleep(1000);
                int num = count.getAndIncrement();
                //创建一条消息
                String msgStr = Thread.currentThread().getName()+ "productor:我是大帅哥，我现在正在生产东西！,count:"+num;
                TextMessage msg = session.createTextMessage(msgStr);
                //发送消息
                messageProducer.send(msg);
                System.out.println(msgStr);
                //提交事务
                session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
