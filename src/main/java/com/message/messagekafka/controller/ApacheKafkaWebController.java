package com.message.messagekafka.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.message.messagekafka.domain.ItemEventLog;
import com.message.messagekafka.repository.ItemEventLogRepository;
import com.message.messagekafka.service.KafkaSender;
import com.message.messagekafka.service.KafkaStreamsService;

@RestController
@RequestMapping(value = "/sample-topic")

public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender ;
	
	@Autowired
	ItemEventLogRepository itemRepository ; 
	
	
	
	
	
	@PostMapping(value="/publish" )
	public String producer(@RequestBody ItemEventLog message) {
		
		/*** send is used for simple topic publishing in kafka **/ 
		message.setId(UUID.randomUUID());
		//ItemEventLog createdEvent = itemRepository.save(message);
		itemRepository.insert(message);
		kafkaSender.send(message);
		
		
		//mySource.output().send(MessageBuilder.withPayload(message).build());
		
		return "Message published successfully " ;
	}
	
	@GetMapping(value="/insert")
	public String insert() {
	
		/* ItemEventLogRepoIMPL dao = new ItemEventLogRepoIMPL();
		dao.itemEventlogInsert("receiving");*/
		
		final ItemEventLog itemEventlog = new ItemEventLog(UUID.randomUUID(),"receiving",100,1000,1);
		ItemEventLog createdEvent = itemRepository.insert(itemEventlog);
		kafkaSender.send(createdEvent);
		return "Success" ;
	}
	
	@PostMapping(value="/stream")
	public String publishStream(@RequestParam("message") String message) {
		KafkaStreamsService streamsSerivce = new KafkaStreamsService();
		System.out.println("Stream message is " + message);
		streamsSerivce.streamData(message);
	
		return "Message published in stream input" ;
	}
}
