package com.ot.micropay.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaOrderCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaOrderCassandraApplication.class, args);
	}

}
