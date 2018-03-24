package com.message.messagekafka.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.message.messagekafka.domain.ItemEventLog;
import com.message.messagekafka.repository.ItemEventLogRepository;

@Service
@EnableKafka

public class KafkaReceiver {

	
	@Autowired
	ItemEventLogRepository itemRepository ;
	
	String messageFromTopic;
	
	String kafkaTopic = "kafkaTool" ;
	
	@KafkaListener(topics = "kafkaTool")
	public void receive(String message) {
		 messageFromTopic = message;
		System.out.println("In Kafka listener" + messageFromTopic );
		final ItemEventLog itemEventlog = new ItemEventLog(UUID.randomUUID(),message,100,1000,1);
		itemRepository.insert(itemEventlog);
		
	}

}
