package com.ot.micropay.order.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.rest.core.annotation.RestResource;

import com.ot.micropay.order.model.InputOrder;
import com.ot.micropay.order.model.Order;


import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends CassandraRepository<Order, UUID> {

    @RestResource(exported = false)
    void deleteByOrderId(UUID orderId);

    @RestResource(exported = false)
    Order save(InputOrder order);

    @RestResource(path="name-and-price-only")
    @Query("SELECT product_name, product_price FROM orders WHERE order_id = :orderId")
    List<Order> findProductNamesAndPricesFromOrder(@Param("orderId") UUID orderId);

    @RestResource(path="order-by-id")
    Order findByOrderId(UUID orderId);

   

}