package com.message.messagekafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.message.messagekafka.domainImpl.ItemEventLogRepoIMPL;
import com.message.messagekafka.repository.ItemEventLogRepository;

@Service
@EnableKafka

public class KafkaSender {

	@Autowired
	KafkaTemplate kafkaTemplate ;
	
	ItemEventLogRepoIMPL dao = new ItemEventLogRepoIMPL();
	
	String kafkaTopic = "kafkaTool" ;
	
	public void send(String message) {
	//	System.out.println("In kafkasender" + message);
		kafkaTemplate.send(kafkaTopic,message);
		//dao.itemEventlogInsert("test");
		
	}
	
}
