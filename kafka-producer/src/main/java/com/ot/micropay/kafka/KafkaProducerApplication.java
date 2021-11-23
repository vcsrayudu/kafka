package com.ot.micropay.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.ot.micropay.kafka.config.Swagger2Config;
import com.ot.micropay.kafka.model.CustomMessage;
@Import({Swagger2Config.class})
@SpringBootApplication
public class KafkaProducerApplication {
	@Value("${spring.kafka.producer.bootstrap-servers}")
	private String kafkaServer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}
	
	@Bean
	KafkaTemplate<String, CustomMessage> kafkaTemplate(){
	    return new KafkaTemplate<>(producerFactory());
	}
	@Bean
	public ProducerFactory<String, CustomMessage> producerFactory(){
	    Map<String, Object> config = new HashMap<>();

	    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
	    config.put(ProducerConfig.ACKS_CONFIG, "all");
	    config.put(ProducerConfig.RETRIES_CONFIG, 0);
	    config.put(ProducerConfig.BATCH_SIZE_CONFIG, 1000);
	    config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	    config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
	    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	    return new DefaultKafkaProducerFactory(config);
	}

}
