package com.bilin.kafka.test;

import com.bilin.kafka.common.KafkaProperties;
import com.bilin.kafka.consumer.KafkaConsumer;

public class KafkaConsumerDemo {
	public static void main(String[] args) {
		KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
		consumerThread.start();
	}
}
