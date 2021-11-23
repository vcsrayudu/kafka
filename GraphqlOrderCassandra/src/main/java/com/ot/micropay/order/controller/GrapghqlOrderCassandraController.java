package com.ot.micropay.order.controller;

import java.time.Instant;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;
import com.ot.micropay.order.service.GraphqlOrderService;
import com.ot.micropay.order.service.OrderNotificationService;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
@RequestMapping("/orders/graphql")
@RestController
public class GrapghqlOrderCassandraController {
	@Autowired
    private OrderNotificationService notificationService;
    private static Logger logger = LoggerFactory.getLogger(GrapghqlOrderCassandraController.class);
    @Autowired    
    private GraphqlOrderService graphqlOrderService;
    @Autowired
    private OrderRepository orderRepository;
	    @PostMapping
	    public ResponseEntity<Object> getAllOrders(@RequestBody String query){
	        logger.info("Entering getAllOrders@GrapghqlOrderCassandraController");
	        	        
	        ExecutionResult execute = graphqlOrderService.getGraphQL().execute(query);
	        return new ResponseEntity<>(execute, HttpStatus.OK);
	    }
	    
	    @PostMapping("/insert")
	    public ResponseEntity<Object> insertOrder(@RequestBody Order order){
	    	order.setOrderId(UUID.randomUUID());
	    	order.setOrderCreationTimestamp(Instant.now());
	    	orderRepository.save(order);
	        return new ResponseEntity<>(order, HttpStatus.OK);
	    }
	}
	 
