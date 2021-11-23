package com.ot.micropay.customer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ot.micropay.customer.model.Order;
import com.ot.micropay.order.model.OrderStatus;
import com.ot.micropay.customer.repository.OrderRepository;
import com.ot.micropay.customer.service.CustomerNotificationService;
@RestController
public class KafkaCustomerCassandraController {
	@Autowired
    private OrderRepository orderRepository;
	

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
      //  notificationService.sendMessage(orderStatus);
        return ResponseEntity.ok(order);
    }
}
