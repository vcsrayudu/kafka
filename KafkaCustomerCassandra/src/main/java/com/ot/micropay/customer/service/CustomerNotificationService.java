package com.ot.micropay.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.ot.micropay.order.model.OrderStatus;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerNotificationService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerNotificationService.class);
	private static final String TOPIC = "users";

	

	@KafkaListener(topics = "${spring.kafka.consumer.topics}",groupId ="${spring.kafka.consumer.group-id}")
	public void consumeMessage(OrderStatus orderStatus){
	logger.info("Order Status Message : {}   ",orderStatus);

	}
}