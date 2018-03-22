package com.message.messagekafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.message.messagekafka.service.KafkaSender;

@RestController
@RequestMapping(value = "/sample-topic")

public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender ;
	
	
	
	
	@GetMapping(value="/publish")
	public String producer(@RequestParam("message") String message) {
		
		/*** send is used for simple topic publishing in kafka **/ 
	
		kafkaSender.send(message);
		
		//mySource.output().send(MessageBuilder.withPayload(message).build());
		
		return "Message published successfully " ;
	}
	
	
}
