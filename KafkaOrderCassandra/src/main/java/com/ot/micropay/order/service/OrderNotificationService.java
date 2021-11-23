package com.ot.micropay.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ot.micropay.order.model.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderNotificationService {

	private static final Logger logger = LoggerFactory.getLogger(OrderNotificationService.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, OrderStatus> kafkaTemplate;

	public void sendMessage(OrderStatus message) {
		ListenableFuture<SendResult<String, OrderStatus>> future = kafkaTemplate.send(TOPIC, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, OrderStatus>>() {

			@Override
			public void onSuccess(SendResult<String, OrderStatus> result) {
				logger.info("Order Status= {} with offset= {}", result.getProducerRecord().value(),
						result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send order status=[{}] due to : {}", message, ex.getMessage());
			}
		});
	}
}