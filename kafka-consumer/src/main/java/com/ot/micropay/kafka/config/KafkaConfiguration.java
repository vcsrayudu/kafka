package com.ot.micropay.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ot.micropay.kafka.model.CustomMessage;
@Configuration
@EnableKafka
public class KafkaConfiguration {
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String KAFKA_SERVER;
	@Bean
	public ConsumerFactory<String, CustomMessage> consumerFactory(){
	    JsonDeserializer<CustomMessage> deserializer = new JsonDeserializer<>(CustomMessage.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);

	    Map<String, Object> config = new HashMap<>();

	    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
	    config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_one");
	    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
	    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
	      return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomMessage> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, CustomMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	    factory.setBatchListener(true);
	    return factory;
	}
}
