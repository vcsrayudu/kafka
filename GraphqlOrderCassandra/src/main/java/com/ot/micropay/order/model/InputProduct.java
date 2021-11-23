package com.ot.micropay.order.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class InputProduct {
	@Column("product_id")
	@CassandraType(type = CassandraType.Name.UUID)
	private UUID productId;
	@Column("product_name")
	@CassandraType(type = CassandraType.Name.TEXT)
	private String productName;
	@Column("product_price")
	@CassandraType(type = CassandraType.Name.DECIMAL)
	private Double productPrice;
	@Column("product_quantity")
	@CassandraType(type = CassandraType.Name.INT)
	private int productQuantity;

	public InputProduct(UUID productId, String productName, int productQuantity, double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
