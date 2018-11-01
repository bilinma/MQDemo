package com.bilin.kafka.spring.annotation;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
 
@Component
public class KafkaCustermer {
	
 
    @KafkaListener(topics = {"spring-topic"})
    public void listener(String content) {
        System.out.println(content);
    }

}
