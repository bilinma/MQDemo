package com.bilin.kafka.test;

import com.bilin.kafka.common.KafkaProperties;
import com.bilin.kafka.consumer.KafkaConsumer2;

public class KafkaConsumerDemo2 {
	public static void main(String[] args) {
		KafkaConsumer2 consumerThread = new KafkaConsumer2(KafkaProperties.topic);
		consumerThread.start();
	}
}
