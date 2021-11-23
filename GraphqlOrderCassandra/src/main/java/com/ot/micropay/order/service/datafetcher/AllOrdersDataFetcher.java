package com.ot.micropay.order.service.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;

import java.util.List;
@Component
public class AllOrdersDataFetcher implements DataFetcher<List<Order>> {
    private OrderRepository orderRepository;
    @Autowired
    public AllOrdersDataFetcher(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }
    @Override
    public List<Order> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return orderRepository.findAll();
    }
}
