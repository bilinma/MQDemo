package com.bilin.activemq.common;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtil {

	//ActiveMq 的默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ 的链接地址
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    //链接工厂
    private static ConnectionFactory connectionFactory;
    //链接对象
    private static Connection connection;
    
    static {
    	try {
        	//创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
            //从工厂中创建一个链接
            connection  = connectionFactory.createConnection();
            //开启链接
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static Session getSession(boolean transacted, int acknowledgeMode){
    	Session session = null;
        try {
            //创建一个事务（这里通过参数可以设置事务的级别）
            session = connection.createSession(transacted,acknowledgeMode);
        } catch (JMSException e) {
            e.printStackTrace();
        }
		return session;
    }

	
	
}
