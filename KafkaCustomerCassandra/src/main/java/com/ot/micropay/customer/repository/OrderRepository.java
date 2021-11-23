package com.ot.micropay.customer.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.rest.core.annotation.RestResource;

import com.ot.micropay.customer.model.Order;
import com.ot.micropay.customer.model.OrderPrimaryKey;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends CassandraRepository<Order, OrderPrimaryKey> {

    @RestResource(exported = false)
    void deleteByKeyOrderId(UUID orderId);

    @RestResource(exported = false)
    void deleteByKeyOrderIdAndKeyCustomerId(UUID orderId, UUID customerId);

    @RestResource(exported = false)
    Order save(Order order);

    @RestResource(path="name-and-price-only")
    @Query("SELECT product_name, product_price FROM orders WHERE order_id = :orderId")
    List<Order> findProductNamesAndPricesFromOrder(@Param("orderId") UUID orderId);

    @RestResource(path="order-by-id")
    List<Order> findByKeyOrderId(UUID orderId);

    @RestResource(path="order-by-customer-id")
    Order findByKeyOrderIdAndKeyCustomerId(UUID orderId, UUID customerId);

}