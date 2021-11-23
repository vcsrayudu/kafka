package com.ot.micropay.order.service.datafetcher;

import java.time.Instant;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ot.micropay.order.controller.GrapghqlOrderCassandraController;
import com.ot.micropay.order.model.InputOrder;
import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {
	 private static Logger logger = LoggerFactory.getLogger(OrderMutationResolver.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public OrderMutationResolver(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }
    public Order createOrder(InputOrder order) {
    	order.setOrderId(UUID.randomUUID());
    	logger.info("orderId: "+order.getOrderId());
    	order.setOrderCreationTimestamp(Instant.now());
        return orderRepository.save(order);
    }
}