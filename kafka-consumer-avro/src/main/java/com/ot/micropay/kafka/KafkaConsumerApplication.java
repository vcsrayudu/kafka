package com.ot.micropay.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.ot.micropay.kafka.config.Swagger2Config;
@SpringBootApplication
public class KafkaConsumerApplication {
	public static void main(String[] args) {
	        SpringApplication.run(KafkaConsumerApplication.class, args);
	    }
	
	
	
	
}
