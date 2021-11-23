package com.ot.micropay.order.service.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;
@Component
public class OrderDataFetcher implements DataFetcher<Order> {
    private OrderRepository orderRepository;
    @Autowired
    public OrderDataFetcher(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public Order get(DataFetchingEnvironment dataFetchingEnvironment) {
        UUID orderId = UUID.fromString(dataFetchingEnvironment.getArgument("orderId"));
        return orderRepository.findByOrderId(orderId);
    }
}