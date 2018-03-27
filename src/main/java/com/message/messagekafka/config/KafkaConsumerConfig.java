package com.message.messagekafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String,String>consumerFactory(){
		
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	@Bean
	public Map<String,Object> consumerConfigs(){
		
		Map<String,Object> props = new HashMap<>() ;
		
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.99.100:29092" );
		
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafkaTool");

		
		return props;
		
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> kafkaListenerContainerFactory(){
		
		 ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		 kafkaListenerFactory.setConsumerFactory(consumerFactory());
		 return kafkaListenerFactory ;
	}
}
