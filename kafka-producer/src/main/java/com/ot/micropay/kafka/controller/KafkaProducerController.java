package com.ot.micropay.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot.micropay.kafka.service.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	private final Producer producer;
	
	@Autowired
	public KafkaProducerController(Producer producer) {
	this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message){
	this.producer.sendMessage(message);
	}
	
}
