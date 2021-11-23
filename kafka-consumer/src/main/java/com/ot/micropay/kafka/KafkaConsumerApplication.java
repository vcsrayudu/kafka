package com.ot.micropay.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.ot.micropay.kafka.config.Swagger2Config;
@Import({Swagger2Config.class})
@SpringBootApplication
public class KafkaConsumerApplication {
	public static void main(String[] args) {
	        SpringApplication.run(KafkaConsumerApplication.class, args);
	    }
	
	
	
	
}
