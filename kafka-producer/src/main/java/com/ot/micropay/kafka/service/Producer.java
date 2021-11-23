package com.ot.micropay.kafka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.ot.micropay.kafka.model.CustomMessage;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, CustomMessage> kafkaTemplate;

	public void sendMessage(String data) {
		logger.info(String.format("$$$ -> Producing message --> %s", data));
		CustomMessage customObject = new CustomMessage();
		customObject.setMessage(data);
		customObject.setMessageId("" + (new Random()).nextInt());
		Message<CustomMessage> customData = MessageBuilder.withPayload(customObject)
				.setHeader(KafkaHeaders.TOPIC, TOPIC).setHeader(KafkaHeaders.PARTITION_ID, 0).build();
		   

		this.kafkaTemplate.send(customData);
	}
}