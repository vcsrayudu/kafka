package com.ot.micropay.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.repository.OrderRepository;
@RestController
public class KafkaOrderCassandraController {
	@Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/orders/delete/order", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@RequestParam UUID orderId){
        orderRepository.deleteByKeyOrderId(orderId);
        return ResponseEntity.ok(orderId.toString());
    }

    @RequestMapping(value = "/orders/delete/product-from-order", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProductFromOrder(@RequestParam UUID orderId, @RequestParam UUID productId){
        orderRepository.deleteByKeyOrderIdAndKeyProductId(orderId, productId);
        return ResponseEntity.ok(orderId + "," + productId);
    }
    @PostMapping(value = "/orders/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }
}
