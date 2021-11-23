package com.ot.micropay.kafka.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class OrderStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID orderId;

	// @CassandraType(type = CassandraType.Name.LIST)
	// @CassandraType(type = CassandraType.Name.LIST, typeArguments = {
	// CassandraType.Name.Product } )
	private List<Product> productList;

	private String orderDescription;
	private String orderStatus;

	private Instant orderCreationTimestamp;

	public OrderStatus(String orderDescription, List<Product> productList, Instant orderCreationTimestamp,String orderStatus) {
		this.orderId = UUID.randomUUID();
		this.orderDescription = orderDescription;
		this.productList = productList;
		this.orderCreationTimestamp = orderCreationTimestamp;
		this.orderStatus=orderStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Instant getOrderCreationTimestamp() {
		return orderCreationTimestamp;
	}

	public void setOrderCreationTimestamp(Instant orderCreationTimestamp) {
		this.orderCreationTimestamp = orderCreationTimestamp;
	}

}
