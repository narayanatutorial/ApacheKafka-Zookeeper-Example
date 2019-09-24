package com.narayanatutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/narayanatutorial")
@RestController
public class ApacheKafkaWebController {

	@Autowired
	private  KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${message.topic.name}")
	public String topic;
	
	@RequestMapping(value="/producer")
	public String sendMessage(@RequestParam("message") String message) {
		kafkaTemplate.send(topic, message);
		return "Message send successfully to topic "+topic;
	}
}
