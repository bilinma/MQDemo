package com.bilin.kafka;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ucloudlink.kafka.spring.config.KafkaProducerServer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class KafkaConfigTest {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Resource
	private KafkaProducerServer kafkaProducer;
	
	@Test
    public void testKafkaProducer() {
        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "1";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);
        
        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");
        
        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }
	
	/**
	 * 向kafka里写数据
	 */
	@Test
	public void testTemplateSend(){
		kafkaTemplate.sendDefault("haha111");
	}

}