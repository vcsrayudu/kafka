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
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ot.micropay.kafka.model.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerService {

	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;

	public void sendMessage(Student message) {
		ListenableFuture<SendResult<String, Student>> future = kafkaTemplate.send(TOPIC, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Student>>() {

			@Override
			public void onSuccess(SendResult<String, Student> result) {
				logger.info("Sent message= {} with offset= {}", result.getProducerRecord().value(),
						result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send message=[{}] due to : {}", message, ex.getMessage());
			}
		});
	}
}