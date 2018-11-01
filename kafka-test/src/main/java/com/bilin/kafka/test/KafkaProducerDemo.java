package com.bilin.kafka.test;

import com.bilin.kafka.common.KafkaProperties;
import com.bilin.kafka.producer.KafkaProducer;

public class KafkaProducerDemo {
	public static void main(String[] args) {
		KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
		producerThread.start();
	}
}
