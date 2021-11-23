package com.ot.micropay.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot.micropay.kafka.service.Consumer;



@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	private final Consumer consumer;

	@Autowired
	public KafkaProducerController(Consumer consumer) {
	this.consumer=consumer;
	}

	@PostMapping(value = "/consume")
	public void consumeMessageFromKafkaTopic(){
	//this.consumer.consumeMessage("");
	}
}
