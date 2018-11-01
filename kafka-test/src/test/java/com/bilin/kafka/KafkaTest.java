package com.bilin.kafka;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

import com.bilin.kafka.common.DateUtil;
public class KafkaTest {
 
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
        
        KafkaTemplate<String, String> kafkaTemplate = (KafkaTemplate<String, String>) applicationContext.getBean("kafkaTemplate");
        
        String dateStr = DateUtil.getDateString();
        
        kafkaTemplate.send("spring_topic", dateStr+"-maxiaobin");
    }

}
