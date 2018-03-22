package com.message.messagekafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableKafka

public class KafkaReceiver {

	
	
	
	String kafkaTopic = "kafkaTool" ;
	
	@KafkaListener(topics = "kafkaTool")
	public void send(String message) {
		System.out.println("In Kafka listener" + message);
		
		
		
	}
	
}
