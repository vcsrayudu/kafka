package com.ot.micropay.kafka.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.ot.micropay.kafka.model.CustomMessage;

@Service
public class Consumer {

private final Logger logger = LoggerFactory.getLogger(Consumer.class);

@KafkaListener(topics = "${kafka.topics}",containerFactory = "kafkaListenerContainerFactory",
autoStartup = "true")
public void consumeMessage(@Payload List<CustomMessage> containers){
logger.info("$$$ -> Consumed Message ID :   "+containers.get(0).getMessageId());
logger.info("$$$ -> Consumed Message :   "+containers.get(0).getMessage());
}
}
