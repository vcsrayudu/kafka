package com.ot.micropay.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ot.micropay.order.model.OrderStatus;
import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;
import com.ot.micropay.order.service.OrderNotificationService;
@RestController
public class KafkaOrderCassandraController {
	@Autowired
    private OrderRepository orderRepository;
	@Autowired
    private OrderNotificationService notificationService;

    @RequestMapping(value = "/orders/delete/order", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@RequestParam UUID orderId){
        orderRepository.deleteByKeyOrderId(orderId);
        return ResponseEntity.ok(orderId.toString());
    }

    @RequestMapping(value = "/orders/delete/product-from-order", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProductFromOrder(@RequestParam UUID orderId, @RequestParam UUID customerId){
        orderRepository.deleteByKeyOrderIdAndKeyCustomerId(orderId, customerId);
        return ResponseEntity.ok(orderId + "," + customerId);
    }
    @PostMapping(value = "/orders/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        orderRepository.save(order);
        OrderStatus orderStatus= new OrderStatus();
        orderStatus.setOrderId(order.getKey().getOrderId().toString());
        orderStatus.setCustomerId(order.getKey().getCustomerId().toString());
        orderStatus.setStatus("ORDER_CREATED");
        notificationService.sendMessage(orderStatus);
        return ResponseEntity.ok(order);
    }
}
