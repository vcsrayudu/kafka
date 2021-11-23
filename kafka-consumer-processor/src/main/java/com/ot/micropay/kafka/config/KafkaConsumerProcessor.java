package com.ot.micropay.kafka.config;

import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ot.micropay.kafka.model.OrderStatus;


@Configuration
public class KafkaConsumerProcessor {
	 private static Logger logger = LoggerFactory.getLogger(KafkaConsumerProcessor.class);
	@Bean
	public Function<KStream<String, OrderStatus>,KStream<String, OrderStatus>> consumerProcessor()
	{
	
		return kstream ->kstream.filter((key,orderStatus)->{
			if(orderStatus.getOrderStatus().equals("ORDER_FINISED"))
			{
				logger.info(""+orderStatus.getOrderStatus());
			}
			else
			{
				logger.info(""+orderStatus.getOrderStatus());
			}
			
			return true;
		});
	}
}
