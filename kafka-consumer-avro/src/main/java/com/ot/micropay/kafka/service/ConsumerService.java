package com.ot.micropay.kafka.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.ot.micropay.kafka.model.Student;

@Service
public class ConsumerService {

private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
@Value(value = "${spring.kafka.consumer.group-id}")
private  String groupId;

@KafkaListener(topics = "${kafka.topics}",groupId ="${spring.kafka.consumer.group-id}")
public void consumeMessage(Student student){
logger.info("App Consumed Message : {}   ",student);

//process the message
//send the notifcation to custer either SMS or mail

}
}
