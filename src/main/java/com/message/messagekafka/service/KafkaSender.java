package com.message.messagekafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.message.messagekafka.domain.ItemEventLog;
import com.message.messagekafka.domainImpl.ItemEventLogRepoIMPL;

@Service
@EnableKafka

public class KafkaSender {

	@Autowired
	KafkaTemplate<String,ItemEventLog> kafkaTemplate ;
	
	ItemEventLogRepoIMPL dao = new ItemEventLogRepoIMPL();
	
	String kafkaTopic = "kafkaTool" ;
	
	public void send(ItemEventLog message) {
	//	System.out.println("In kafkasender" + message);
		kafkaTemplate.send(kafkaTopic,message);
		//dao.itemEventlogInsert("test");
		
	}
	
}
